package com.ifmo.task2;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;

class BTreeNode {
    @Getter
    private final ArrayList<Integer> arrayList = new ArrayList<>();
    @Getter
    private final int[] keys;
    private final int MinDeg;
    @Getter
    private final BTreeNode[] children;
    @Getter
    @Setter
    private int num;
    @Getter
    private final boolean isLeaf;


    public BTreeNode(int deg, boolean isLeaf) {
        this.MinDeg = deg;
        this.isLeaf = isLeaf;
        this.keys = new int[2 * this.MinDeg - 1];
        this.children = new BTreeNode[2 * this.MinDeg];
        this.num = 0;
    }

    BTreeNode search(int key) {
        arrayList.clear();
        int i = 0;
        BTreeNode tmp;
        while (i < num && key > keys[i]) {
            arrayList.add(keys[i]);
            i++;
        }
        if (i < num && keys[i] == key) {
            arrayList.add(keys[i]);
            return this;
        }
        tmp = children[i].search(key);
        arrayList.addAll(children[i].arrayList);
        return tmp;
    }

    void insertNotFull(int key) {
        int i = num - 1;
        if (isLeaf) {
            while (i >= 0 && keys[i] > key) {
                keys[i + 1] = keys[i];
                i--;
            }
            keys[i + 1] = key;
            num = num + 1;
        } else {
            while (i >= 0 && keys[i] > key)
                i--;
            if (children[i + 1].num == 2 * MinDeg - 1) {
                splitChild(i + 1, children[i + 1]);

                if (keys[i + 1] < key)
                    i++;
            }
            children[i + 1].insertNotFull(key);
        }
    }


    void splitChild(int i, BTreeNode y) {
        BTreeNode z = new BTreeNode(y.MinDeg, y.isLeaf);
        z.num = MinDeg - 1;
        for (int j = 0; j < MinDeg - 1; j++)
            z.keys[j] = y.keys[j + MinDeg];
        y.num = MinDeg - 1;
        for (int j = num; j >= i + 1; j--)
            children[j + 1] = children[j];
        children[i + 1] = z;
        for (int j = num - 1; j >= i; j--)
            keys[j + 1] = keys[j];
        keys[i] = y.keys[MinDeg - 1];
        num = num + 1;
    }


    ArrayList<Integer> traverse() {
        int i;
        arrayList.clear();
        for (i = 0; i < num; i++) {
            if (!isLeaf) {
                arrayList.addAll(children[i].traverse());
            }
            arrayList.add(keys[i]);
            System.out.printf(" %d", keys[i]);
        }
        if (!isLeaf) {
            arrayList.addAll(children[i].traverse());
        }
        return arrayList;
    }

    void remove(int key) {
        int idx = findKey(key);
        if (idx < num && keys[idx] == key) {
            if (isLeaf)
                removeFromLeaf(idx);
            else
                removeFromNonLeaf(idx);
        } else {
            if (isLeaf) {
                System.out.printf("The key %d is does not exist in the tree\n", key);
                return;
            }
            children[idx].remove(key);
        }
    }

    private int findKey(int key) {
        int idx = 0;
        while (idx < num && keys[idx] < key)
            ++idx;
        return idx;
    }


    private void removeFromLeaf(int idx) {
        if (num - (idx + 1) >= 0) System.arraycopy(keys, idx + 1, keys, idx + 1 - 1, num - (idx + 1));
        num--;
    }

    private void removeFromNonLeaf(int idx) {
        int key = keys[idx];
        if (children[idx + 1].num >= MinDeg) {
            int succ = getSucc(idx);
            keys[idx] = succ;
            children[idx + 1].remove(succ);
        } else {
            merge(idx);
            children[idx].remove(key);
        }
    }

    private int getSucc(int idx) {
        BTreeNode cur = children[idx + 1];
        return cur.keys[0];
    }

    private void merge(int idx) {
        BTreeNode child = children[idx];
        BTreeNode sibling = children[idx + 1];
        child.keys[MinDeg - 1] = keys[idx];
        if (sibling.num >= 0) System.arraycopy(sibling.keys, 0, child.keys, MinDeg, sibling.num);
        for (int i = idx + 1; i < num; ++i)
            keys[i - 1] = keys[i];
        for (int i = idx + 2; i <= num; ++i)
            children[i - 1] = children[i];
        child.num += sibling.num + 1;
        num--;
    }
}

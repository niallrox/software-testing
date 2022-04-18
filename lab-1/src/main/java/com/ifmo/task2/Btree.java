package com.ifmo.task2;


import lombok.Getter;

import java.util.ArrayList;

public class Btree {
    @Getter
    private final ArrayList<Integer> arrayList = new ArrayList<>();
    private BTreeNode root;
    private final int MinDeg;


    public Btree() {
        try {
            this.root = null;
            this.MinDeg = 3;
        } catch (Throwable e) {
            
        }
    }

    public ArrayList<Integer> traverse() {
        arrayList.clear();
        if (root != null) {
            arrayList.addAll(root.traverse());
        }
        System.out.println();
        return arrayList;
    }


    public BTreeNode search(int key) {
        arrayList.clear();
        BTreeNode tmp;
        tmp = root == null ? null : root.search(key);
        arrayList.addAll(root.getArrayList());
        return tmp;
    }

    public void insert(int key) {
        if (root == null) {
            root = new BTreeNode(MinDeg, true);
            root.getKeys()[0] = key;
            root.setNum(1);
        } else {
            if (root.getNum() == 2 * MinDeg - 1) {
                BTreeNode s = new BTreeNode(MinDeg, false);
                s.getChildren()[0] = root;
                s.splitChild(0, root);
                int i = 0;
                s.getChildren()[i].insertNotFull(key);
                root = s;
            } else
                root.insertNotFull(key);
        }
    }

    public void remove(int key) {
        if (root == null) {
            System.out.println("The tree is empty");
            return;
        }
        root.remove(key);
    }
}
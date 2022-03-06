package com.ifmo.task2;


import java.util.ArrayList;

public class Btree {
    public ArrayList<Integer> arrayList = new ArrayList<>();
    BTreeNode root;
    int MinDeg;

    
    public Btree() {
        this.root = null;
        this.MinDeg = 3;
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
        arrayList.addAll(root.arrayList);
        return tmp;
    }

    public void insert(int key) {

        if (root == null) {

            root = new BTreeNode(MinDeg, true);
            root.keys[0] = key;
            root.num = 1;
        } else {
            
            if (root.num == 2 * MinDeg - 1) {
                BTreeNode s = new BTreeNode(MinDeg, false);
                
                s.children[0] = root;
                
                s.splitChild(0, root);
                
                int i = 0;
                if (s.keys[0] < key)
                    i++;
                s.children[i].insertNotFull(key);

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

        if (root.num == 0) { 
            
            
            if (root.isLeaf)
                root = null;
            else
                root = root.children[0];
        }
    }
}
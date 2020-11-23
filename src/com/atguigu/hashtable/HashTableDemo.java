package com.atguigu.hashtable;

import java.util.Scanner;

public class HashTableDemo {

    public static void main(String[] args) {
        HashTable hashTable = new HashTable(9);

        String key = "";
        Scanner scanner = new Scanner(System.in);

        System.out.println("add:  添加雇员");
        System.out.println("list: 显示雇员");
        System.out.println("find: 查找雇员");
        System.out.println("del: 删除雇员");
        System.out.println("exit: 退出系统");

        while(true) {
            key = scanner.next();
            switch (key) {
                case "add":
                    System.out.println("输入id");
                    int id = scanner.nextInt();
                    System.out.println("输入名字");
                    String name = scanner.next();
                    Emp emp = new Emp(id, name);
                    hashTable.add(emp);
                    break;
                case "list":
                    hashTable.list();
                    break;
                case "find":
                    System.out.println("请输入要查找的id");
                    id = scanner.nextInt();
                    hashTable.find(id);
                    break;
                case "del":
                    System.out.println("输入要删除的id");
                    id = scanner.nextInt();
                    hashTable.delete(id);
                    break;
                case "exit":
                    scanner.close();
                    System.exit(0);
                default:
                    break;
            }
        }
    }

}

class HashTable {
    private EmpLinkedList[] empLinkedListArr;
    private int size;

    public HashTable(int size) {
        this.size = size;
        empLinkedListArr = new EmpLinkedList[size];

        for (int i = 0; i < size; i++) {
            EmpLinkedList temp = new EmpLinkedList();
            temp.listNo = i;
            empLinkedListArr[i] = temp;
        }
    }

    public void add(Emp emp) {
        empLinkedListArr[hashFunc(emp.id)].add(emp);
    }

    public void list() {
        for (int i = 0; i < size; i++) {
            empLinkedListArr[i].list();
        }
    }

    public void find(int id) {
        Emp emp = empLinkedListArr[hashFunc(id)].find(id);
        if(emp != null) {//找到
            System.out.printf("在第%d条链表中找到 雇员 id = %d\n", hashFunc(id), id);
        } else {
            System.out.println("在哈希表中，没有找到该雇员~");
        }
    }

    public void delete(int id) {
        empLinkedListArr[hashFunc(id)].delete(id);
    }

    public int hashFunc(int id) {
        return id % size;
    }
}

class Emp {
    public int id;
    public String name;
    public Emp next;

    public Emp(int id, String name) {
        this.id = id;
        this.name = name;
    }
}

class EmpLinkedList {
    private Emp first;
    public int listNo;

    public void add(Emp emp) {
        if (this.first == null) {
            first = emp;
            return;
        }

        Emp curPointer = this.first;

        boolean addFlag = false;

        while (true) {
            if (curPointer == first) {
                if (emp.id < curPointer.id) {
                    emp.next = curPointer;
                    this.first = emp;
                    break;
                }
            }

            if (curPointer.next == null) {
                addFlag = true;
                break;
            }


            if (emp.id < curPointer.next.id) {
                addFlag = true;
                break;
            }

            curPointer = curPointer.next;
        }

        if (addFlag) {
            emp.next = curPointer.next;
            curPointer.next = emp;
        }
    }

    public void list() {
        System.out.print("第" + this.listNo + "条链表的信息为：");

        Emp curPointer = this.first;

        while (true) {
            if (curPointer == null)
                break;

            System.out.printf(" => id=%d name=%s\t", curPointer.id, curPointer.name);

            curPointer = curPointer.next;
        }

        System.out.println();
    }

    public Emp find(int id) {
        Emp curPointer = this.first;

        while (true) {
            if (curPointer == null)
                return null;

            if (curPointer.id == id)
                return curPointer;

            curPointer = curPointer.next;
        }
    }

    public void delete(int id) {
        if (this.first == null) {
            return;
        }

        Emp curPointer = this.first;

        boolean delFlag = false;

        while (true) {
            if (curPointer == first) {
                if (id == curPointer.id) {
                    this.first = this.first.next;
                    break;
                }
            }

            if (curPointer.next == null)
                break;

            if (id == curPointer.next.id) {
                delFlag = true;
                break;
            }

            curPointer = curPointer.next;
        }

        if (delFlag) {
            curPointer.next = curPointer.next.next;
        }
    }



}

















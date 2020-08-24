package com.atguigu.linkedlist;

public class Josepfu {

	public static void main(String[] args) {

		SingleCircleLinkedList sc = new SingleCircleLinkedList();

		sc.addBoy(125);
		sc.printBoy();

		sc.josepfuOut(10, 20);
		sc.printBoy();
	}

}

class SingleCircleLinkedList {

	private Boy first = null;

	private int num;

	public void addBoy(int num) {
		if (num < 1) {
			System.out.println("num必须大于等于1");
			return;
		}

		this.num = num;
		Boy lastBoy = null;

		for (int i = 1; i <= num; i++) {
			Boy newBoy = new Boy(i);

			if (this.first == null) {
				this.first = newBoy;
			} else {
				lastBoy.setNext(newBoy);
			}

			newBoy.setNext(first);
			lastBoy = newBoy;
		}
	}

	public void printBoy() {
		if (this.first == null) {
			System.out.println("没有节点");
			return;
		}

		Boy cur = this.first;

		while (true) {
			System.out.printf("%d\n", cur.getNo());

			if (cur.getNext() == this.first) {
				break;
			}

			cur = cur.getNext();
		}
	}

	public void josepfuOut(int startNo, int countNum) {
		if (this.first == null) {
			System.out.println("没有节点");
			return;
		}

		if (startNo < 1 || startNo > this.num || countNum < 1) {
			System.out.println("不合法的数据输入");
			return;
		}

		Boy preBoy = this.first;
		while (preBoy.getNext() != this.first) { //让preBoy在first的后面
			preBoy = preBoy.getNext();
		}

		for (int i = 0; i < startNo - 1; i++) { //初始化开始的位置
			this.first = this.first.getNext();
			preBoy = preBoy.getNext();
		}

		while (true) {
			if (preBoy == this.first) { //只剩一个节点
				System.out.printf("当前出圈的编号: %d\n", this.first.getNo());
				this.first = null;
				break;
			}

			for (int i = 0; i < countNum - 1; i++) {
				this.first = this.first.getNext();
				preBoy = preBoy.getNext();
			}

			System.out.printf("当前出圈的编号: %d\n", this.first.getNo());

			this.first = this.first.getNext();
			preBoy.setNext(this.first);
		}
	}
}


class Boy {

	private int no;

	private Boy next;


	public Boy(int no) {
		this.no = no;
	}

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public Boy getNext() {
		return next;
	}

	public void setNext(Boy next) {
		this.next = next;
	}

}

















































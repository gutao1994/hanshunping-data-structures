package com.atguigu.linkedlist;

import java.util.Stack;

public class SingleLinkedListDemo {

	public static void main(String[] args) {

		HeroNode hero1 = new HeroNode(1, "宋江", "及时雨");
		HeroNode hero2 = new HeroNode(2, "卢俊义", "玉麒麟");
		HeroNode hero3 = new HeroNode(3, "吴用", "智多星");
		HeroNode hero4 = new HeroNode(4, "林冲", "豹子头");


		SingleLinkedList singleLinkedList = new SingleLinkedList();

//		singleLinkedList.addToRear(hero1);
//		singleLinkedList.addToRear(hero4);
//		singleLinkedList.addToRear(hero2);
//		singleLinkedList.addToRear(hero3);

		singleLinkedList.addByOrder(hero4);
		singleLinkedList.addByOrder(hero1);
		singleLinkedList.addByOrder(hero3);
//		singleLinkedList.addByOrder(hero2);

		singleLinkedList.list();
		System.out.println();

		System.out.println("反转单链表~~");
		reversetList(singleLinkedList.getHead());
		singleLinkedList.list();
		System.out.println();

//		System.out.println("测试逆序打印单链表, 没有改变链表的结构~~");
//		reversePrint(singleLinkedList.getHead());
//		System.out.println();

		singleLinkedList.list();
		System.out.println();


//		singleLinkedList.update(new HeroNode(2, "小卢", "玉麒麟~~"));
//
//		singleLinkedList.list();
//		System.out.println();
//
//		singleLinkedList.del(1);
//		singleLinkedList.del(4);
//		singleLinkedList.del(4);
//
//		singleLinkedList.list();
//		System.out.println();
	}

	/**
	 * 将单链表反转打印，不可破坏原来的链表结构
	 */
	public static void reversePrint(HeroNode head) {
		HeroNode cur = head.next;

		Stack<HeroNode> stack = new Stack<HeroNode>();

		while (cur != null) {
			stack.push(cur);
			cur = cur.next;
		}

		while (stack.size() > 0) {
			System.out.println(stack.pop());
		}
	}

	/**
	 * 将单链表反转
	 */
	public static void reversetList(HeroNode head) {
		HeroNode reverseHead = new HeroNode(0, "", "");
		HeroNode cur = head.next;
		HeroNode next = null;

		while (cur != null) {
			next = cur.next;

			cur.next = reverseHead.next;
			reverseHead.next = cur;

			cur = next;
		}

		head.next = reverseHead.next;
	}

	/**
	 * 查找单链表中的倒数第index个结点 【新浪面试题】
	 */
	public static HeroNode findLastIndexNode(HeroNode head, int index) {
		int length = getLength(head);

		if (index <= 0 || index > length) {
			return null;
		}

		HeroNode cur = head.next;
		for (int i = 0; i < length - index; i++) {
			cur = cur.next;
		}

		return cur;
	}

	/**
	 * 返回的就是有效节点的个数
	 */
	public static int getLength(HeroNode head) {
		HeroNode cur = head.next;

		int count = 0;

		while (cur != null) {
			count++;
			cur = cur.next;
		}

		return count;
	}

}


class SingleLinkedList {

	private HeroNode head = new HeroNode(0, "", "");

	public HeroNode getHead() {
		return this.head;
	}

	/**
	 * 添加到末尾
	 */
	public void addToRear (HeroNode newHeroNode) {
		HeroNode tmp = this.head;

		while (true) {
			if (tmp.next == null) {
				break;
			}

			tmp = tmp.next;
		}

		tmp.next = newHeroNode;
	}

	/**
	 * 按顺序添加
	 */
	public void addByOrder (HeroNode newHeroNode) {
		HeroNode tmp = this.head;

		boolean flag = false; //是否存在相同no的节点

		while (true) {
			if (tmp.next == null) {
				break;
			}

			if (newHeroNode.no == tmp.next.no) {
				flag = true;
				break;
			}

			if (newHeroNode.no < tmp.next.no) {
				break;
			}

			tmp = tmp.next;
		}

		if (flag) {
			System.out.printf("存在相同节点:%d，无法添加\n", newHeroNode.no);
		} else {
			newHeroNode.next = tmp.next;
			tmp.next = newHeroNode;
		}
	}

	public void update(HeroNode newHeroNode) {
		HeroNode tmp = this.head.next;

		boolean hasNode = false;

		while (true) {
			if (tmp == null) {
				break;
			}

			if (newHeroNode.no == tmp.no) {
				hasNode = true;
				break;
			}

			tmp = tmp.next;
		}

		if (hasNode) {
			tmp.name = newHeroNode.name;
			tmp.nickname = newHeroNode.nickname;
		} else {
			System.out.printf("没有找到 编号 %d 的节点，不能修改\n", newHeroNode.no);
		}
	}

	public void del (int no) {
		HeroNode tmp = head;

		boolean hasNode = false;

		while (true) {
			if (tmp.next == null) {
				break;
			}

			if (no == tmp.next.no) {
				hasNode = true;
				break;
			}

			tmp = tmp.next;
		}

		if (hasNode) {
			tmp.next = tmp.next.next;
		} else {
			System.out.printf("要删除的 %d 节点不存在\n", no);
		}
	}

	public void list () {
		HeroNode tmp = this.head.next;

		while (true) {
			if (tmp == null)
				break;

			System.out.println(tmp);

			tmp = tmp.next;
		}
	}
}


class HeroNode {

	public int no;

	public String name;

	public String nickname;

	public HeroNode next;

	public HeroNode(int no, String name, String nickname) {
		this.no = no;
		this.name = name;
		this.nickname = nickname;
	}

	@Override
	public String toString() {
		return "HeroNode [no=" + no + ", name=" + name + ", nickname=" + nickname + "]";
	}



}








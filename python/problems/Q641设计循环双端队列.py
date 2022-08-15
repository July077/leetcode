# 641.
# 设计循环双端队列
# 设计实现双端队列。
#
# 实现
# MyCircularDeque
# 类:
#
# MyCircularDeque(int
# k) ：构造函数, 双端队列最大为
# k 。
# boolean
# insertFront()：将一个元素添加到双端队列头部。 如果操作成功返回
# true ，否则返回
# false 。
# boolean
# insertLast() ：将一个元素添加到双端队列尾部。如果操作成功返回
# true ，否则返回
# false 。
# boolean
# deleteFront() ：从双端队列头部删除一个元素。 如果操作成功返回
# true ，否则返回
# false 。
# boolean
# deleteLast() ：从双端队列尾部删除一个元素。如果操作成功返回
# true ，否则返回
# false 。
# int
# getFront() )：从双端队列头部获得一个元素。如果双端队列为空，返回 - 1 。
# int
# getRear() ：获得双端队列的最后一个元素。 如果双端队列为空，返回 - 1 。
# boolean
# isEmpty() ：若双端队列为空，则返回
# true ，否则返回
# false  。
# boolean
# isFull() ：若双端队列满了，则返回
# true ，否则返回
# false 。


class MyCircularDeque:

    def __init__(self, k: int):
        self.front = 0
        self.rear = 0
        self.capacity = k + 1
        self.arr = [0 for _ in range(self.capacity)]

    def insertFront(self, value: int) -> bool:
        if self.isFull():
            return False

        self.front = (self.front - 1 + self.capacity) % self.capacity
        self.arr[self.front] = value
        return True

    def insertLast(self, value: int) -> bool:
        if self.isFull():
            return False
        self.arr[self.rear] = value
        self.rear = (self.rear + 1) % self.capacity
        return True

    def deleteFront(self) -> bool:
        if self.isEmpty():
            return False

        self.front = (self.front + 1) % self.capacity
        return True

    def deleteLast(self) -> bool:
        if self.isEmpty():
            return False

        self.rear = (self.rear - 1 + self.capacity) % self.capacity
        return True

    def getFront(self) -> int:
        if self.isEmpty():
            return -1
        return self.arr[self.front]

    def getRear(self) -> int:
        if self.isEmpty():
            return -1
        return self.arr[(self.rear - 1 + self.capacity) % self.capacity]

    def isEmpty(self) -> bool:
        return self.front == self.rear

    def isFull(self) -> bool:
        return (self.rear + 1) % self.capacity == self.front

# Your MyCircularDeque object will be instantiated and called as such:
# obj = MyCircularDeque(k)
# param_1 = obj.insertFront(value)
# param_2 = obj.insertLast(value)
# param_3 = obj.deleteFront()
# param_4 = obj.deleteLast()
# param_5 = obj.getFront()
# param_6 = obj.getRear()
# param_7 = obj.isEmpty()
# param_8 = obj.isFull()

package uottawa.winter.problems.binarytree;

import java.util.Stack;

public class StackForMaxElement {

    public static void main(String[] args) {
        MyStack elements = new MyStack();
        elements.push(10);
        elements.push(2);
        elements.push(5);
        elements.push(50);

        System.out.println(elements.pop());
    }


    public static class MyStack extends Stack {
        public Object push(Object newValue) {
            if (this.isEmpty() == false) {
                Integer currentObject = (Integer)this.pop();
                Integer newObject = (Integer)newValue;
                if (currentObject > newObject) {
                    super.push(newValue);
                    super.push(currentObject);
                } else {
                    super.push(currentObject);
                    super.push(newValue);
                }
            } else {
                super.push(newValue);
            }

            return newValue;
        }
    }

}

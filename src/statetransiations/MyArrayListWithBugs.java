/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package statetransiations;

/**
 *
 * @author Opinator
 */
public class MyArrayListWithBugs {

    // Class with bugs
    private Object[] list;
    int nextFree;

    public MyArrayListWithBugs() {

        list = new Object[5];
        nextFree = 0;
    }

    public void add(Object o) {

        if (list.length <= nextFree) {

            list = getLongerList();
        }
        list[nextFree] = o;
        nextFree++;

    }

    public int size() {
        return nextFree;
    }

    public Object get(int index) {
        if (index < 0 || nextFree < index) {
            throw new IndexOutOfBoundsException("Invalid Index" + index);
        }
        return list[index];
    }

    public void add(int index, Object o) {
        if (index < 0 || nextFree < index) {
            throw new IndexOutOfBoundsException("Invalid Index" + index);
        }
        if (list.length <= nextFree) {
            list = getLongerList();
        }
        for (int i = nextFree - 1; i > index; i--) {
            list[i] = list[i - 1];
        }
        list[index] = o;
    }

    public Object remove(int index) {
        if (index < 0 || nextFree < index) {
            throw new IndexOutOfBoundsException("Invalid Index" + index);
        }
        for (int i = index; i < nextFree - 1; i++) {
            list[i] = list[i + 1];
        }
        nextFree--;
        return list[index];
    }

    private Object[] getLongerList() {
        Object[] tempList = new Object[list.length * 2];
        for (int i = 0; i < list.length; i++) {
            tempList[i] = list[i];
        }
        return tempList;
    }

    public int getListLength() {
        return list.length;
    }

}

package com.traning1ch3.test;

import java.util.concurrent.atomic.AtomicReference;

/**
 * 描述:
 * <p>
 *
 * @author gyc
 * @version 1.0
 * @date 2018/10/26 0026
 */
public class AtomicReference2 {
    public static void main(String[] args){
        AtomicReference<UserTest> atomicReference = new AtomicReference();

        UserTest gyc = new UserTest("gyc", 32);
        atomicReference.set(gyc);
        atomicReference.compareAndSet(gyc,new UserTest("gyc2",33));
        System.out.println(atomicReference.get());
    }

    private static class UserTest {
        private String name;
        private Integer age;

        public UserTest(String name,Integer age) {
            this.name = name;
            this.age = age;
        }

        @Override
        public String toString() {
            return "UserTest{" +
                    "name='" + name + '\'' +
                    ", age=" + age +
                    '}';
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public Integer getAge() {
            return age;
        }

        public void setAge(Integer age) {
            this.age = age;
        }
    }
}

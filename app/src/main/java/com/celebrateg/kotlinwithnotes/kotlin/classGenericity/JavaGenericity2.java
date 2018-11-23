package com.celebrateg.kotlinwithnotes.kotlin.classGenericity;

import com.example.issuser.myapplication.kotlin.classExtends.Base;
import com.example.issuser.myapplication.kotlin.classExtends.SubClass1;

/**
 * @Author CelebrateG
 * @Description java中泛型的限制
 * @Date 2018/10/30
 */
public class JavaGenericity2 {
    void demo(Source<String> strs) {
//        Source<Object> source = strs; // 在 Java 中不允许

        /**
         * java 中不允许的原因:
         * List<String> strs = new ArrayList<String>();
         * List<Object> objs = strs; // 如果Java允许
         * objs.add(1); // 这里我们把一个整数放入一个字符串列表
         * String s = strs.get(0); //  ClassCastException：无法将整数转换为字符串
         */


        /**
         * 在这里由于 Source 是接口,而不是集合,完全可以将
         * String 类型的返回转为 Object 的返回,是安全的,为什么:
         */
        //String 转为 Object
        Object obj = strs.nextT();
//        int i = strs.nextT(); //编译会报错
        /**
         * 只能从中读取的对象为生产者，只能写入的对象为消费者
         * 也就是说你不能像 list 一样往里面写入,不能被消费。从而避免出现转换异常
         * Kotlin 中，有一种方法向编译器解释以上情况
         * 称为声明处型变--详情见 KotlinGenericity1
         */
    }

    void demo2(Source<SubClass1> source) {

    }


}

/**
 * 该接口中不存在任何以 T 作为参数的方法，
 * 只是方法返回 T 类型值
 *
 * @param <T>
 */
interface Source<T> {
    T nextT();
}

/**
 * 方法返回 Base 类型值及其子类
 *
 * @param <T>
 */
interface Source2<T extends Base> {
    T next2T();
}


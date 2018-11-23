package com.example.issuser.myapplication

import com.example.issuser.myapplication.kotlin.annotation.TEST_TIMEOUT
import com.example.issuser.myapplication.kotlin.annotation.remove
import com.example.issuser.myapplication.kotlin.annotation.removeAt
import com.example.issuser.myapplication.kotlin.annotation.testJsonSerializer
import com.example.issuser.myapplication.kotlin.classAttr.Person
import com.example.issuser.myapplication.kotlin.classAttr.Team
import com.example.issuser.myapplication.kotlin.classConstructor.*
import com.example.issuser.myapplication.kotlin.classData.User
import com.example.issuser.myapplication.kotlin.delegationPattern.*
import com.example.issuser.myapplication.kotlin.classEnum.*
import com.example.issuser.myapplication.kotlin.classExpand.*
import com.example.issuser.myapplication.kotlin.classExtends.SubClass4
import com.example.issuser.myapplication.kotlin.classGenericity.*
import com.example.issuser.myapplication.kotlin.classInterface.Child
import com.example.issuser.myapplication.kotlin.classNested.AnInterface
import com.example.issuser.myapplication.kotlin.classNested.Outer
import com.example.issuser.myapplication.kotlin.classNested.Outer2
import com.example.issuser.myapplication.kotlin.classNested.Outer3
import com.example.issuser.myapplication.kotlin.`object`.*
import com.example.issuser.myapplication.kotlin.grammer.*
import com.example.issuser.myapplication.kotlin.lambda.*
import com.example.issuser.myapplication.kotlin.other.*
import com.example.issuser.myapplication.kotlin.other.Player
import org.junit.Test
/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class KotlinUnitTest {
    /**
     * BasicGrammer测试
     */
    @Test
    fun basicGrammerTest() {
        println(sum(1, 2))
        println(sum1(2, 2))
        println(sum2(3, 2))
        printSum(4, 2)
        vars(1, 3, 5)
    }

    @Test
    fun basicGrammerTest2() {
        testStr()
        println("-----------------------------")
        testNull(null)
        testNull2(null) //会抛出异常
        testNull3(null)
    }

    @Test
    fun basicGrammerTest3() {
        getStringLength("look")
        getStringLength2("see")
        getStrngLength3("summer")
    }

    @Test
    fun basicGrammerTest4() {
        arange()
    }

    @Test
    fun basicGrammerTest5() {
        typeExchange()
    }

    @Test
    fun basicGrammerTest6() {
        testArray()
    }

    @Test
    fun basicGrammerTest7() {
        comparNumber(100)
        comparNumber(1000)
        anotherCompare(100)
    }

    @Test
    fun basicGrammerTest8() {
        decimalDigitValue('3')
        printDollar()
    }


    /**
     * Grammer1测试
     */
    @Test
    fun gm1_useWhenExample1() {
        useWhenExample1()
    }

    @Test
    fun gm1_useWhenExample2() {
        useWhenExample2()
    }

    @Test
    fun gm1_useWhenExample3() {
        useWhenExample3()
    }

    /**
     * Grammer2测试
     */
    @Test
    fun gm2_useForExample1() {
        useForExample1()
    }

    @Test
    fun gm2_useForExample2() {
        useForExample2()
    }

    @Test
    fun gm2_useWhileExample() {
        useWhileExample()
    }

    @Test
    fun gm2_useDoWhileExample() {
        useDoWhileExample()
    }

    /**
     * Grammer3测试
     */
    @Test
    fun gm3_example1() {
        example1()
    }

    @Test
    fun gm3_example2() {
        example2()
    }

    @Test
    fun gm3_example3() {
        example3()
    }

    @Test
    fun gm3_example4() {
        example4()
    }

    @Test
    fun gm3_example5() {
        example5()
    }

    @Test
    fun gm3_example6() {
        example6()
    }

    @Test
    fun gm3_example7() {
        example7()
    }


    /**
     * Lambda1 测试
     */
    @Test
    fun lambda1Test() {
        lambda()
    }

    /**
     * Lambda2 测试
     */
    @Test
    fun lambda2Test() {
        testFunction()
    }

    /**
     * Lambda3 测试
     */
    @Test
    fun lambda3Test() {
        println(result)
        println(result2)
        println(pdd)
    }


    /**
     * class属性测试
     */
    @Test
    fun classAttrTest1() {
        var p = Person(0)
        println("age:${p.age}")
        p.age = 5
        println("age:${p.age}")
        println("hasBrothers:${p.hasBrothers}")
        p.brothers = 0
        println("hasBrothers:${p.hasBrothers}")
//        println("name:${p.name}")
    }

    @Test
    fun classAttrTest2() {
        var team = Team()
        team.testA()
        team.person = Person(1)
        println(team.person)
        team.teamName = "WE"
        println(team.teamName)
    }

    /**
     * classAttr测试
     */
    @Test
    fun classConstructorTest1() {
        val name1 = "UZI"
        val name2 = "麻辣香锅"
        val age = 18
        Constructor1(name1, name2, age)
        println("------------------------------------")
        Constructor1(name1)
        println("------------------------------------")
        Constructor2()
        println("------------------------------------")
        Constructor2(name2)
        println("------------------------------------")
        SubClass1(name2)
        println("------------------------------------")
        SubClass2(name1, name2)
        println("------------------------------------")
        SubClass3(name2)
        println("------------------------------------")
    }

    /**
     * classNested测试
     */
    @Test
    fun classNestedTest1() {
        var out1 = Outer.Nested().foo()
        println("out1:$out1")
        var out2 = Outer2().Inner()
        println("out2:${out2.foo()}")
        println(out2.innerTest())
        var out3 = Outer3()
        out3.setInterface(object : AnInterface {
            override fun aMethod() {
                println("对象表达式创建匿名内部类的实例")
            }
        })
    }

    /**
     * classExtends测试
     */
    @Test
    fun classExtendsTest() {
        var sb3 = com.example.issuser.myapplication.kotlin.classExtends.SubClass3()
        sb3.v()
        sb3.cv()
        var sb2 = com.example.issuser.myapplication.kotlin.classExtends.SubClass2()
        sb2.v()
        sb2.cv()
        var sb1 = com.example.issuser.myapplication.kotlin.classExtends.SubClass1(12)
        sb1.v()
        sb1.cv()
        var sb4 = SubClass4()
        sb4.caller(sb1)
        sb4.caller(sb2)
        sb4.caller(sb3)
    }

    /**
     * classInterface测试
     */
    @Test
    fun classInterfaceTest() {
        var child = Child()
        println("child name:${child.name}")
        child.bar()
        child.foo()
    }

    /**
     * classExpand 测试
     */
    @Test
    fun classExpandTest1() {
        val mutable = mutableListOf<Int>(1, 2, 3)
        mutable.swap(0, 2)

        var a: Any? = null
        println(a.toString())
    }

    @Test
    fun classExpandTest2() {
        //输出 "c"，因为调用的扩展函数只取决于参数 c 的声明类型
        printFoo(D())
        var c = C()
        println(c.a)
    }

    @Test
    fun classExpandTest3() {
        var e = E()
        e.foo()
        e.foo(0)
    }

    @Test
    fun classExpandTest4() {
        println(MyClass.name)
        println(MyClass.innerName)
        println(MyClass.id)
        println(MyClass().id)
        //调用的半生对象外部的扩展函数foo()，foo3()
        MyClass.foo()
        MyClass.foo3()
        MyClass.companionFun1()
        //通过其他函数优先调用伴生对象内部的扩展函数以及外部的扩展函数
        MyClass().bar()
    }

    @Test
    fun classExpandTest5() {
        var q = Q()
        var w = W()
        w.caller(q)
    }

    @Test
    fun classExpandTest6() {
        var j = J()
        var j1 = J1()
        var k = K()
        var k1 = K1()
        //两个都输出 J.foo() in K
        k.caller(j)
        k.caller(j1)
        //两个都输出 J.foo() in K1
        k1.caller(j)
        k1.caller(j1)
    }


    /**
     * 数据类测试
     */
    @Test
    fun classDataTest() {
        val jack = User(name = "Jack", age = 1)
        val olderJack = jack.copy(age = 21)
        println(jack)
        println(olderJack)
        //解构声明
        val (name, age) = jack
        println("$name age is $age")
    }

    /**
     * 密封类测试
     */
    @Test
    fun classSealedTest() {

    }


    /**
     * 泛型测试
     */
    @Test
    fun kotlinGenericityTest1() {
        var kt : KtSource<String> = object : KtSource<String>{
            override fun nextT(): String {
                return "KtSource"
            }
        }
        demo(kt)
        var c : Comparable<Number> = object : Comparable<Number>{
            override fun compareTo(other: Number): Int {
                return compareValues(10.0,3.0)
            }
        }
        demo2(c)
    }

    @Test
    fun kotlinGenericityTest2() {
        example()
    }

    @Test
    fun classGenericityTest1() {
        var box = Box(1)
        val box2 = Box<String>("box2")
        val box3 = boxIn(3)
        var box4 = boxIn("box4")
        println(box.value)
        println(box2.value)
        println(box3.value)
        println(box4.value)

        doPrintln(1)
        doPrintln("1")
        doPrintln(true)
    }

    @Test
    fun classGenericityTest2() {
        constraint(listOf<Int>(1, 2, 3))
    }

    @Test
    fun classGenericityTest3() {
        var runoobStr: Runoob<String> = Runoob("runoobStr")
        var runoobInt = Runoob(10)
        var runoobAny: Runoob<Any> = Runoob("runoobAny")
        println(runoobStr.foo())
        println(runoobInt.foo())
        println(runoobAny.foo())

        var runoaStr: Runooa<String> = Runooa()
        var runooaAny: Runooa<Any> = Runooa()
        runoaStr.foo("runooaStr")
        runooaAny.foo("runoobAny")
    }

    /**
     * 枚举类测试
     */
    @Test
    fun classEnumTest() {
        println(Color1.valueOf("WHITE"))
        println(Color2.BLUE.toString())
        println(Shape.valueOf("OVAL"))
        println(P.TALKING)

        for (name in Shape.values()) {
            print(name)
        }
        println()
        for (name in Color2.values()) {
            print("${name.rgb} ")
        }
        println()
        printAllValues<P>()
    }


    /**
     * 对象测试
     */
    @Test
    fun classObjectTest1() {
        simpleUseObj()
        println("A.x:${A(3).y},ab.y:${ab.y}")
    }

    @Test
    fun classObjectTest2() {
        var m = M()
        m.bar()
    }

    @Test
    fun classObjectTest3() {
        countClicks()
    }

    @Test
    fun classObjectTest4() {
        NetBarManager.registerLeaguer()
        LOLTeam.aMethod()
    }

    @Test
    fun classObjectTest5() {
        jsgFunction()
    }


    /**
     * 操作符重载测试
     */
    @Test
    fun operatorOverLoadingTest() {
        testOperator()
    }

    @Test
    fun operatorOverLoadingTest2() {
        compoundAssignment1()
        compoundAssignment2()
        compoundAssignment3()
    }

    @Test
    fun operatorOverLoadingTest3() {
        unaryOperator()
    }

    @Test
    fun operatorOverLoadingTest4() {
        equalOperator1(null)
        println("--------------------------")
        equalOperator2()
    }

    @Test
    fun operatorOverLoadingTest5() {
        compare()
    }

    /**
     * 注解测试
     * TEST_TIMEOUT 需要标记为 const val
     */
    @Test(timeout = TEST_TIMEOUT)
    fun testAnnotition() {
        //会提示使用哪个函数来代替
        remove(2)
        removeAt(2)
    }

    @Test
    fun testAnnotition6() {
        testJsonSerializer()
    }


    /**
     * 反射测试
     */
    @Test
    fun reflectTest1() {
        reflect1()
        println("----------------------")
        fooTest()
        println("----------------------")
        kfInvokeUse()
        println("----------------------")
        kPUse()
        println("----------------------")
        memberKPUse()
    }

    @Test
    fun reflectTest2() {
        println(serialize(Player("UZI", "the LOL Player")))
    }

    /**
     * 解构声明
     */
    @Test
    fun deconstrucitonTest() {
        deconstruction()
        deconstruction2()
        deconstruction3()
        println("------------------------")
        deconstruction4()
    }

    /**
     * 集合
     */
    @Test
    fun setTest() {
        setFun1()
        println("------------------------")
        setFun2()
        println("------------------------")
        setFun3()
    }


    /**
     * 委托模式测试
     */
    @Test
    fun classDelegationPatternTest1() {
        testFun()
    }

    @Test
    fun classDelegationPatternTest2() {
        val e = Example()
        println(e.p)
        e.p = "Example.p"

        aFun()
    }

    @Test
    fun classDelegationPatternTest3() {
        lazyFun1()
        println("--------------------------------------")
        lazyFun2()
        println("--------------------------------------")
        println(lazyValue)
        println(lazyValue)
    }

    @Test
    fun classDelegationPatternTest4() {
        attrChangeFunction1()
        println("--------------------------------------")
        attrChangeFunction2()
        println("--------------------------------------")
        attrChangeFunction3()
        println("--------------------------------------")
        myObservable()
        println("--------------------------------------")
        myVetoable()
        println("--------------------------------------")
        attrChangeFunction4()
    }

    @Test
    fun classDelegationPatternTest5() {
        ajFunction()
        println("--------------------------------------")
        checkPlayer()
    }

    @Test
    fun classDelegationPatternTest6() {
        var f = Fisherman()

        partialDelegation {
            f
        }
    }

    @Test
    fun classDelegationPatternTest7() {
        var ui = MyUI()
    }


}


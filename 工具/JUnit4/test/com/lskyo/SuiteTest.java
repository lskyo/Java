package com.lskyo;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;


/**
 * 
 * 测试套件类
 * 1、测试运行器改为Suite.class
 * 2、要测试的类放入@Suite.SuiteClasses
 * 3、写一个测试套件的入口类，该类不能包含任何东西
 *
 */
@RunWith(Suite.class)
@Suite.SuiteClasses({TaskTest1.class, TaskTest2.class, TaskTest3.class})
public class SuiteTest {
}

package com.lskyo;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;


/**
 * 
 * �����׼���
 * 1��������������ΪSuite.class
 * 2��Ҫ���Ե������@Suite.SuiteClasses
 * 3��дһ�������׼�������࣬���಻�ܰ����κζ���
 *
 */
@RunWith(Suite.class)
@Suite.SuiteClasses({TaskTest1.class, TaskTest2.class, TaskTest3.class})
public class SuiteTest {
}

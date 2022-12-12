package oop.labs.lab2;

import oop.labs.lab2.tests.IntMatrixImmutableTest;
import oop.labs.lab2.tests.IntMatrixMutableTest;
import oop.labs.lab2.tests.IntMatrixTest;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({
        IntMatrixTest.class,
        IntMatrixMutableTest.class,
        IntMatrixImmutableTest.class
})
public class TestingAuto {}
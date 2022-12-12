package oop.labs.lab2;

import oop.labs.lab2.tests.IntMatrixImmutableTest;
import oop.labs.lab2.tests.IntMatrixMathTest;
import oop.labs.lab2.tests.IntMatrixMutableTest;
import oop.labs.lab2.tests.IntMatrixBaseTest;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({
        IntMatrixBaseTest.class,
        IntMatrixMathTest.class,
        IntMatrixMutableTest.class,
        IntMatrixImmutableTest.class
})
public class TestingAuto {}
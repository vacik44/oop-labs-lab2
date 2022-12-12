package oop.labs.lab2;

import oop.labs.lab2.tests.IntMatrixImmutableTest;
import oop.labs.lab2.tests.IntMatrixMutableTest;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({
        IntMatrixMutableTest.class,
        IntMatrixImmutableTest.class
})
public class Testing {}
//package com.springbootlab;
//
//import com.springbootlab.controller.ClientController;
//import org.junit.jupiter.api.*;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import static org.junit.jupiter.api.Assertions.assertEquals;
//
//class MyFirstJUnitJupiterTests {
//
//    private static final Logger log = LoggerFactory.getLogger(ClientController.class);
//
//    @BeforeAll
//    private static void beforeAllTests() {
//        log.info("Before all tests");
//    }
//
//    @AfterAll
//    private static void afterAllTests() {
//        log.info("After all tests");
//    }
//
//    @BeforeEach
//    private static void beforeEachTest(TestInfo testInfo) {
//        log.info(String.format("About to execute [%s]",
//                testInfo.getDisplayName()));
//    }
//
//    @AfterEach
//    private static void afterEachTest(TestInfo testInfo) {
//        log.info(String.format("Finished executing [%s]",
//                testInfo.getDisplayName()));
//    }
//
//    @Disabled("Disabled until bug #99 has been fixed")
//    @Test
//    void addition() {
//        assertEquals(2, 1 + 1);
//    }
//
//}
package sampleapp;

public class practice {
    public static void main(String[] args) {
        System.out.println("Starting Selenium Tests...");

        // Execute each test class sequentially
        runTest("Functional Tests", FunctionalTests::main, args);
        runTest("Input Validation Tests", InputValidationTests::main, args);
        runTest("Edge Case Tests", EdgeCaseTests::main, args);
        runTest("Security Tests", SecurityTests::main, args);
        runTest("Account Creation Test", AccountCreationTest::main, args);
        runTest("SSL Test", SSLTest::main, args);

        System.out.println("\nAll tests completed successfully!");
    }

    private static void runTest(String testName, RunnableTest testClass, String[] args) {
        System.out.println("\n--- Starting " + testName + " ---");
        long startTime = System.currentTimeMillis();
        try {
            testClass.run(args);
            long endTime = System.currentTimeMillis();
            System.out.println("--- " + testName + " Completed Successfully in " + (endTime - startTime) + " ms ---");
        } catch (Exception e) {
            System.err.println("Error during " + testName + ": " + e.getMessage());
            e.printStackTrace();
            System.exit(1); // Exit with failure code if any test fails
        }
    }

    @FunctionalInterface
    interface RunnableTest {
        void run(String[] args);
    }
}

from WasRun import WasRun
from TestCase import TestCase
from TestSuite import TestSuite
from TestResult import TestResult
from BadSetup import BadSetup

class TestCaseTest(TestCase):
    def setUp(self):
    	self.result = TestResult()

    def testTemplateMethod(self):
	test = WasRun("testMethod")
        test.run(self.result)
        assert("setUp testMethod tearDown "  == test.log)

    def testResult(self):
        test = WasRun("testMethod") 
	test.run(self.result)
        assert("1 run, 0 failed" == self.result.summary())

    def testFailedResult(self):
        test = WasRun("testBrokenMethod")
	test.run(self.result)
        assert("1 run, 1 failed" ==  self.result.summary())

    def testFailedResultFormatting(self):
        self.result.testStarted()
        self.result.testFailed()
        assert("1 run, 1 failed" == self.result.summary())

    def testExceptionInSetup(self):
	test = BadSetup("testMethod")
	test.run(self.result)
	assert("1 run, 1 failed" == self.result.summary())
    
    def testSuite(self):
	suite = TestSuite.emptySuite()
	suite.add(WasRun("testMethod"))
	suite.add(WasRun("testBrokenMethod"))
	suite.run(self.result)
	assert("2 run, 1 failed" == self.result.summary())
    
    def testSuiteFromCases(self):
    	test = WasRun("testMethod")
	suite = TestSuite.fromTestCase(test)
	assert(len(suite.tests) == 1)
	suite.run(self.result)
	assert("1 run, 0 failed" == self.result.summary())

suite = TestSuite.emptySuite()
suite.add(TestCaseTest("testTemplateMethod"))
suite.add(TestCaseTest("testResult"))
suite.add(TestCaseTest("testSuiteFromCases"))
suite.add(TestCaseTest("testSuite"))
suite.add(TestCaseTest("testFailedResult"))
suite.add(TestCaseTest("testFailedResultFormatting"))
suite.add(TestCaseTest("testExceptionInSetup"))
result = TestResult()
suite.run(result)
print result.summary()

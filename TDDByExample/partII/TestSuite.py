from TestResult import TestResult

class TestSuite:
	def __init__(self, tests):
		self.tests = tests

 	@classmethod
	def emptySuite(cls):
		return cls([])

	@classmethod
	def fromTestCase(cls,testcase):
		instance = cls([testcase])
		return instance

	def add(self, test):
		self.tests.append(test)
	
	def run(self, result):
		for test in self.tests:
			test.run(result)

from TestResult import TestResult

class TestCase:
    def __init__(self,name):
      self.name = name

    def setUp(self):
      pass

    def run(self):
      result = TestResult()
      result.testStarted()
      self.setUp()
      method = getattr(self, self.name)
      method()
      self.tearDown()
      return result

    def tearDown(self):
	pass

from TestResult import TestResult

class TestCase:
    def __init__(self,name):
      self.name = name

    def setUp(self):
      pass

    def run(self, result):
      result.testStarted()
      try:
      	self.runTest()
      except:
        result.testFailed()

    def runTest(self):
    	self.setUp()
	method = getattr(self, self.name)
	method()
	self.tearDown()
    
    def tearDown(self):
	pass

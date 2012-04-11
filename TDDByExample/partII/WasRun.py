from TestCase import TestCase

class WasRun(TestCase):
   def __init__(self,name):
      TestCase.__init__(self, name)

   def setUp(self):
      self.log = "setUp "
  
   def testMethod(self):
      self.wasRun = 1
      self.log = self.log + "testMethod "

   def tearDown(self):
      self.log = self.log + "tearDown "
   

from WasRun import WasRun

class BadSetup(WasRun):
	def __init__(self, name):
		WasRun.__init__(self, name)

	def setUp(self):
		self.log = "about to throw exception, so fuck yoself"
		raise Exception

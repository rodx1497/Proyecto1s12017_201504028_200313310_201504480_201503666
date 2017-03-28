class nodosd1:
	def setinfo(self,informa):
		self.sig = None
		self.ante = None
		self.arriba = None
		self.abajo  = None
		self.atras = None
		self.adelante = None
		self.info = informa
		self.contra = None
		self.nomcomp=None
		self.empresa = None
		self.departamente=None
		self.avl  = None
	def getsig(self):
		return self.sig
	def getante(self):
		return self.ante
	def getarriba(self):
		return self.arriba
	def getabajo(self):
		return self.abajo
	def getatras(self):
		return self.atras
	def getadelante(self):
		return self.adelante

	def getinfo(self):
		return self.info

	def setsig(self, informacion):
		self.sig = informacion
	def setante(self, informacion):
		self.ante = informacion
	def setarriba(self, informacion):
		self.arriba = informacion
	def setabajo(self, informacion):
		self.abajo = informacion
	def setatras(self, informacion):
		self.atras= informacion
	def setadelante(self, informacion):
		self.adelante = informacion

	def setnuevoinfo(self, informacion):
		self.info = informacion

	def setcontra(self, informacion):
		self.contra= informacion

	def setcompleto(self, informacion):
		self.nomcomp= informacion
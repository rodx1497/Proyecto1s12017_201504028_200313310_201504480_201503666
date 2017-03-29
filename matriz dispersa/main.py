
import listasimple
import cola
import pila
import listad
from flask import Flask, request, Response
app = Flask("EDD_codigo_ejemplo")

#Ejemplo de una clase, todos los metodos de las clases deben de tener como parametro el "self", que es como el .this en Java

class Usuario():
	global jj 
	global listas 
	global colaa
	global pilaa
	global listadd
	global listasletra
	global listasdir
	pilaa = pila.pila1()
	listas = listasimple.ListaS()
	colaa = cola.cola1()
	listadd = listad.listad1()
	listasdir = listasimple.ListaS()
	

	jj="porque"
	def __init__(self, password, correo, nombre):
		self.nombre = nombre
		self.password = password
		bself.correo = correo

	@app.route('/metodoWeb1',methods=['POST'])
	def hello():
		parametro = str(request.form['dato'])
		dato2 = str(request.form['dato2'])

		return "Hola " + str(parametro) + "!"

	@app.route('/listasagregar',methods=['POST'])
	def darvalor():
		parametro = str(request.form['dato1'])
		listas.enlistar(parametro)
		listas.grafica()
		reg ="Ingreso: ",str(parametro)
		return str(reg)

	@app.route('/listasb',methods=['POST']) 
	def mos():		#return str(jj)
		parametro = str(request.form['dato1'])
		listas.grafica()
		return str (listas.buscar(parametro))

	@app.route('/listasel',methods=['POST']) 
	def elinm():		#return str(jj)
		parametro = str(request.form['dato1'])
		ff12 = str (listas.borrar(int(parametro)))
		listas.grafica()
		return  ff12
		

	@app.route('/colaq',methods=['POST']) 
	def col1():		#return str(jj)
		parametro = str(request.form['dato1'])
		reg ="Ingreso: ",str(parametro)
		colaa.push(parametro)
		colaa.grafica()
		return str(reg)

	@app.route('/coladq',methods=['POST']) 
	def elinmpop():		#return str(jj)
		parametro = str(request.form['dato1'])
		envv = str (colaa.pop())
		colaa.grafica()
		return envv

	@app.route('/pilap',methods=['POST']) 
	def pilaaegr1():		#return str(jj)
		parametro = str(request.form['dato1'])
		reg ="Ingreso: ",str(parametro)
		pilaa.push(parametro)
		pilaa.grafica()
		return str(reg)

	@app.route('/pilapp',methods=['POST']) 
	def pilaelinmpop():		#return str(jj)
		parametro = str(request.form['dato1'])
		nmk=str (pilaa.pop())
		pilaa.grafica()
		return nmk

	@app.route('/matrizagregar',methods=['POST']) 
	def matriza():		#return str(jj)
		parametro = str(request.form['dato1'])
		reg ="Ingreso: ",str(parametro)
		g =parametro.split("@")
		listadd.agregar(g[0],g[1])
		listadd.graficar()
		return str(reg)

	@app.route('/matrizeliminar1',methods=['POST']) 
	def matrizaelima():		#return str(jj)
		parametro = str(request.form['dato1'])
		reg ="Elimino: ",str(parametro)
		g =parametro.split("@")
		listadd.eliminar(g[0],g[1])
		listadd.graficar()
		return str(reg)

	@app.route('/matrizbletra',methods=['POST']) 
	def matrizall():		#return str(jj)
		parametro = str(request.form['dato1'])
		
		gh= listadd.bletral(parametro)
		#ff =listasletra.tam()
		return gh

	@app.route('/matrizbletra1',methods=['POST']) 
	def matrizall11():		#return str(jj)
		parametro = str(request.form['dato1'])
		parametro2 = str(request.form['dato2'])
		gh= listadd.bletral1(parametro,int(parametro2))
		#ff =listasletra.tam()
		return gh

	@app.route('/matrizbdir',methods=['POST']) 
	def matrizall3rr():		#return str(jj)
		parametro = str(request.form['dato1'])
		
		gh= listadd.bletraldir(parametro)
		#ff =listasletra.tam()
		return gh

	@app.route('/matrizbdir1',methods=['POST']) 
	def matrizall13r3r1():		#return str(jj)
		parametro = str(request.form['dato1'])
		parametro2 = str(request.form['dato2'])
		gh= listadd.bletraldir1(parametro,int(parametro2))
		#ff =listasletra.tam()
		return gh




if __name__ == "__main__":
  app.run(debug=True, host='0.0.0.0')



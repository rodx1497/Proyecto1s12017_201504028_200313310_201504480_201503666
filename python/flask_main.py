
import listad
from flask import Flask, request, Response
app = Flask("EDD_Proyecto1")


class Usuario():
	global jj 
	global matriz_dispersa

	matriz_dispersa = listad.listad1()

	@app.route('/lista_agregar',methods=['POST'])
	def darvalor():
		usuario = str(request.form['usuario'])
		contra = str(request.form['contrasena']) 
		nombre = str(request.form['nombre'])
		empresa= str(request.form['empresa'])
		dep = str(request.form['departamento'])
		
		listad.agregar(usuario,contra,nombre,empresa,dep)
		return "Agregado usuario"

	@app.route('/lista_agregar_activo',methods=['POST'])
	def darvaloractivo():
		usuario = str(request.form['usuario'])
		empresa= str(request.form['empresa'])
		dep = str(request.form['departamento'])
		nombre_activo = str(request.form['activo'])
		descripcion = str(request.form['descripcion'])
		listad.buscar_user_agregar_activo(usuario,empresa,dep,nombre_activo,descripcion)
		return "Agregado activo"

if __name__ == "__main__":
  app.run(debug=True, host='0.0.0.0')
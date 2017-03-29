
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

	@app.route('/lista_compobrar_contra',methods=['POST'])
	def comprobar():
		usuario = str(request.form['usuario'])
		contra = str(request.form['contrasena'])
		empresa= str(request.form['empresa'])
		dep = str(request.form['departamento'])
		#comprobar la contrasena debulve true o false (usuario,contra,empresa,dep)   * debuelve none si no existe el nodo
		return 	listad.comprobar_inicio(usuario,contra,empresa,dep)

	@app.route('/lista_modificar',methods=['POST'])
	def modif():
		usuario = str(request.form['usuario'])
		empresa= str(request.form['empresa'])
		dep = str(request.form['departamento'])
		num_unico =str(request.form['id_producto'])
		nombre =str(request.form['nombre_producto'])
		descripcion=str(request.form['descripcion_producto'])
		listad.buscar_user_modificar_activo(usuario,empresa,dep,num_unico,nombre,descripcion)
		return 	"modificado"

	@app.route('/lista_eliminar',methods=['POST'])
	def elim():
		usuario = str(request.form['usuario'])
		empresa= str(request.form['empresa'])
		dep = str(request.form['departamento'])
		num_unico =str(request.form['id_producto'])
		nombre =str(request.form['nombre_producto'])
		descripcion=str(request.form['descripcion_producto'])
		listad.eliminar_activo(usuario,empresa,dep,num_unico,nombre,descripcion)
		return 	"eliminado"

	@app.route('/listar_activos',methods=['POST'])
	def todos():
		return 	listad.todos_activos()

	@app.route('/lista_activos_user',methods=['POST'])
	def algunos():
		usuario = str(request.form['usuario'])
		empresa= str(request.form['empresa'])
		dep = str(request.form['departamento'])
		return 	listad.ver_por_user(usuario,empresa,dep)


if __name__ == "__main__":
  app.run(debug=True, host='0.0.0.0')
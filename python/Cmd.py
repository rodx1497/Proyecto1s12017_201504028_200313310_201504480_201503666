import subprocess

class cmd:
    def __init__(self):
        dato=None

    def escribir_dot(self, entrada, nombre_archivo):
    	f=open(nombre_archivo+".dot","w")
    	f.write(entrada+"\n")
    	f.close()

    def ejecutar_cmd(self, nombre_archivo):
        lista = ["dot", "-Tpng", nombre_archivo+".dot", "-o", nombre_archivo+".png"]
        proc = subprocess.Popen(lista, stdin = subprocess.PIPE, stdout = subprocess.PIPE)
        stdout, stderr = proc.communicate('dir c:\\')
        stdout

# Pasos para configurar javaparser como un proyecto maven

- Si quieren obviarse para empezar la parte del repo y git bájense de acá el [javaparser](http://javaparser.org). 

- Sino clonen el repo y luego desde la vista de java pongan import y elijan existing maven project y busquen la ruta de donde lo clonaron.

- Bájense maven desde [acá](https://maven.apache.org/download.cgi). Yo me bajé el zip.

- Luego, en eclipse, vayan a windows -- preferences -- maven -- installations y elijan el maven que se acaban de bajar.

- Seleccónenlo

- Listo

# Pasos para correr

- Botón derecho sobre el proyecto y van hasta run:
  - Si elijen maven clean eso borra artefactos viejos.
  
  - Maven test corre los unit test
  
  - Maven install corre los unit test y luego genera los artefactos
  
### El flujo debería ser, clean, luego test y por último install (si si, el install corre los test pero tiene sentido correr antes los test para evitar que, si alguno te falla, generes el artefacto).

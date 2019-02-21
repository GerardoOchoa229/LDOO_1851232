var date= new Date();
var hora=date.getHours();
var nombre;
nombre=prompt('Ingresa tu nombre: ');
document.write('Hola ');
document.write(nombre);
document.write(' bienvenido');
if(hora>=6 && hora<12){
    document.write(', buenos dias.');
}else if(hora>=12 && hora<19){
    document.write(', buenas tardes.');
}else{
    document.write(', buenas noches.');
}

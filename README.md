Consideraciones:

    -Huella incorporada a actionbar.xml mediante atributo app:logo
    
    -Flecha de subir modificada mediante la siguiente instrucción en UltimasFavoritas.java:
         miActionBar.setNavigationIcon(R.drawable.back);
         
    -UltimasFavoritas reordena aleatoriamente la ArraList<Mascota> mascotas. Como es dummy, no debe mostrar
     las últimas reateadas
    
    -En UltimasFavoritas se muestra el hueso blanco por reutilizar el CardView, pero no se le asigna funcionalidad,
     aunque se clicke no cambia el número de rates de la mascota en esa activity
    

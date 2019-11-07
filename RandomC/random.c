
// Programa en C que genera numeros en un rango
#include <stdio.h> 
#include <stdlib.h> 
#include <time.h> 
    
// Driver code 
int main() 
{ 
 char entrada[30];
  
 	while(entrada!='\0'){
 		
  	scanf("%s", entrada); // Escribimos un texto
    int lower = 100, upper = 200, count = 1;  
    // Usa currenTime para poder generar numeros aleatorios  
    srand(time(0));   
    printRandoms(lower, upper, count); 
}
  
    return 0; 
} 

// Genera y imprime numeros aleatorios 
// Numeros en un rango [lower, upper].
// Se introduce el salto del contador  
void printRandoms(int lower, int upper,   int count) 
{ 
    int i; 
    for (i = 0; i < count; i++) { 
        int num = (rand() % 
           (upper - lower + 1)) + lower; 
        printf("%d \n",  num); 
    } 
} 


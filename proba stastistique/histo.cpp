// test_couleur.cpp : Seuille une image en niveau de gris

#include <stdio.h>
#include "image_ppm.h"
using namespace std;
int main(int argc, char* argv[])
{
  char cNomImgLue[256], histo[256];
  int nH, nW, nTaille, S;
  
  if (argc != 2) 
     {
       printf("Usage: ImageIn.pgm\n"); 
       exit (1) ;
     }
   
   sscanf (argv[1],"%s",cNomImgLue) ;

   OCTET *ImgIn;
   
   lire_nb_lignes_colonnes_image_pgm(cNomImgLue, &nH, &nW);
   nTaille = nH * nW;
  
   allocation_tableau(ImgIn, OCTET, nTaille);
   lire_image_pgm(cNomImgLue, ImgIn, nH * nW);
            for (int i=0; i < 255; i++)
        {
        histo[i] = 0;
         }
	
    for (int i=0; i < nTaille; i++)
    {
     ++histo[ImgIn[i]];
     }


    string const monFichier("histo.dat");
    ofstream monFlux(monFichier.c_str());

    if(monFlux){
        for(int i = 0 ; i < 255;++i)
            monFlux << i << " " << histo[i] << endl;
    }
    else{
        cout << "ERREUR " << endl;
    }
 
   free(ImgIn); 

   return 1;
}
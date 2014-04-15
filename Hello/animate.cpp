#include<windows.h>
#include <mmsystem.h>
#include <GL/gl.h>
#include <GL/glut.h>
#include<stdio.h>
#include<stdlib.h>
#define starttypex 440
#define starttypey 500
void drawmenu();
int flag=0;
int bomb=0;
int card =0;
char c= 'b';
int charcount = -1;
int newkey = 0;

int endtypex = starttypex + 150;//change 50 for width of the card here
int endtypey = starttypey - 130;//change 200 to height of the card here

int typeposx=starttypex;
int typeposy = starttypey;





void myinit(void)
{
    glClearColor (1.0, 1.0, 1.0, 0.0);
    // glMatrixMode(GL_PROJECTION);      /* In World coordinates: */
    // glLoadIdentity();                 /* position the "clipping rectangle" */
    // gluOrtho2D(0,750,0,750);        /* at -B/2, its right edge at +B/2, its bottom */
    // glMatrixMode(GL_MODELVIEW);       /* edge at -B/2 and its top edge at +B/2 */


}


void drawtab(int x,int y,int height,int width)

{


	glColor3f(0.5f, 0.0f, 1.0f); // make this vertex purple
    glBegin(GL_QUADS);
               glVertex2i(x,y);
               glColor3f(1.0f, 0.0f, 0.0f); // make this vertex red
               glVertex2i(x+width,y);

               glColor3f(0.5f, 0.0f, 1.0f); // make this vertex purple
               //glColor3f(0.0f, 1.0f, 0.0f); // make this vertex green
               glVertex2i(x+width,y+height);

               glColor3f(1.0f, 0.0f, 0.0f); // make this vertex red
               //glColor3f(1.0f, 1.0f, 0.0f); // make this vertex yellow
               glVertex2i(x,y+height);
       glEnd();

}
void drawtab1(int x,int y,int height,int width)

{

    glColor3f(1.0f, 0.0f,0.0f); // make this vertex purple
    glBegin(GL_QUADS);
               glVertex2i(x,y);
               //glColor3f(1.0f, 0.0f, 0.0f); // make this vertex red
               glVertex2i(x+width,y);

              // glColor3f(0.0f, 1.0f, 0.0f); // make this vertex green
               glVertex2i(x+width,y+height);

               //glColor3f(1.0f, 1.0f, 0.0f); // make this vertex yellow
               glVertex2i(x,y+height);
       glEnd();
       glColor3f(0.0f, 1.0f,0.0f);
       glBegin(GL_QUADS);
                      glVertex2i(x+2,y+2);
                      //glColor3f(1.0f, 0.0f, 0.0f); // make this vertex red
                      glVertex2i(x+width-2,y+2);

                     // glColor3f(0.0f, 1.0f, 0.0f); // make this vertex green
                      glVertex2i(x+width-2,y+height-2);

                      //glColor3f(1.0f, 1.0f, 0.0f); // make this vertex yellow
                      glVertex2i(x+2,y+height-2);
              glEnd();


}
void point()
{
    glColor3f(0.0,0.0,0.0);
    glPointSize(5.0);
    glBegin(GL_POINTS);
        glVertex2i(150,150);
    glEnd();
    glFlush();
}
void drawcrackertext(int x,int y)
{
  glColor3f (0.1,0.1,1.0);
  glRasterPos2i(x,y);

  glutBitmapCharacter(GLUT_BITMAP_TIMES_ROMAN_24,'C');
  glutBitmapCharacter(GLUT_BITMAP_TIMES_ROMAN_24,'r');
  glutBitmapCharacter(GLUT_BITMAP_TIMES_ROMAN_24,'a');
  glutBitmapCharacter(GLUT_BITMAP_TIMES_ROMAN_24,'c');
  glutBitmapCharacter(GLUT_BITMAP_TIMES_ROMAN_24,'k');
  glutBitmapCharacter(GLUT_BITMAP_TIMES_ROMAN_24,'e');
  glutBitmapCharacter(GLUT_BITMAP_TIMES_ROMAN_24,'r');
  glutBitmapCharacter(GLUT_BITMAP_TIMES_ROMAN_24,'s');

}
void drawgreetingstext(int x,int y)
{
  glColor3f (0.1,0.1,1.0);
  glRasterPos2i(x,y);

  glutBitmapCharacter(GLUT_BITMAP_TIMES_ROMAN_24,'G');
  glutBitmapCharacter(GLUT_BITMAP_TIMES_ROMAN_24,'r');
  glutBitmapCharacter(GLUT_BITMAP_TIMES_ROMAN_24,'e');
  glutBitmapCharacter(GLUT_BITMAP_TIMES_ROMAN_24,'e');
  glutBitmapCharacter(GLUT_BITMAP_TIMES_ROMAN_24,'t');
  glutBitmapCharacter(GLUT_BITMAP_TIMES_ROMAN_24,'i');
  glutBitmapCharacter(GLUT_BITMAP_TIMES_ROMAN_24,'n');
  glutBitmapCharacter(GLUT_BITMAP_TIMES_ROMAN_24,'g');
  glutBitmapCharacter(GLUT_BITMAP_TIMES_ROMAN_24,'s');


}
void drawcrackersubmenu(int x,int y)
{
    drawtab(15,616,30,85);
    glColor3f (0.1,0.1,1.0);
    glRasterPos2i(x,y);

    //Rocket
    glutBitmapCharacter(GLUT_BITMAP_TIMES_ROMAN_24,'R');
    glutBitmapCharacter(GLUT_BITMAP_TIMES_ROMAN_24,'o');
    glutBitmapCharacter(GLUT_BITMAP_TIMES_ROMAN_24,'c');
    glutBitmapCharacter(GLUT_BITMAP_TIMES_ROMAN_24,'k');
    glutBitmapCharacter(GLUT_BITMAP_TIMES_ROMAN_24,'e');
    glutBitmapCharacter(GLUT_BITMAP_TIMES_ROMAN_24,'t');

    drawtab(15,582,30,85);
    glColor3f (0.1,0.1,1.0);
    y = y-34;
    glRasterPos2i(x,y);

    glutBitmapCharacter(GLUT_BITMAP_TIMES_ROMAN_24,'B');
    glutBitmapCharacter(GLUT_BITMAP_TIMES_ROMAN_24,'o');
    glutBitmapCharacter(GLUT_BITMAP_TIMES_ROMAN_24,'m');
    glutBitmapCharacter(GLUT_BITMAP_TIMES_ROMAN_24,'b');

    drawtab(15,548,30,85);
    glColor3f (0.1,0.1,1.0);
    y = y-34;
    glRasterPos2i(x,y);

    glutBitmapCharacter(GLUT_BITMAP_TIMES_ROMAN_24,'W');
    glutBitmapCharacter(GLUT_BITMAP_TIMES_ROMAN_24,'h');
    glutBitmapCharacter(GLUT_BITMAP_TIMES_ROMAN_24,'e');
    glutBitmapCharacter(GLUT_BITMAP_TIMES_ROMAN_24,'e');
    glutBitmapCharacter(GLUT_BITMAP_TIMES_ROMAN_24,'l');

}
void drawgreetingssubmenu(int x,int y)
{
    drawtab(x-20,y-8,30,85);
    glColor3f (0.1,0.1,1.0);
    glRasterPos2i(x,y);

    //Rocket
    glutBitmapCharacter(GLUT_BITMAP_TIMES_ROMAN_24,'C');
    glutBitmapCharacter(GLUT_BITMAP_TIMES_ROMAN_24,'a');
    glutBitmapCharacter(GLUT_BITMAP_TIMES_ROMAN_24,'r');
    glutBitmapCharacter(GLUT_BITMAP_TIMES_ROMAN_24,'d');
    glutBitmapCharacter(GLUT_BITMAP_TIMES_ROMAN_24,' ');
    glutBitmapCharacter(GLUT_BITMAP_TIMES_ROMAN_24,'1');

    drawtab(x-20,542,30,85);
    glColor3f (0.1,0.1,1.0);
    y = y-34;
    glRasterPos2i(x,y);

    glutBitmapCharacter(GLUT_BITMAP_TIMES_ROMAN_24,'C');
    glutBitmapCharacter(GLUT_BITMAP_TIMES_ROMAN_24,'a');
    glutBitmapCharacter(GLUT_BITMAP_TIMES_ROMAN_24,'r');
    glutBitmapCharacter(GLUT_BITMAP_TIMES_ROMAN_24,'d');
    glutBitmapCharacter(GLUT_BITMAP_TIMES_ROMAN_24,' ');
    glutBitmapCharacter(GLUT_BITMAP_TIMES_ROMAN_24,'2');

}

void drawcrackerstab(int x,int y)
{
 drawtab1(x,y,30,85);
 drawcrackertext(x+15,y+8);
}
void drawgreetingstab(int x,int y)
{
 drawtab1(x,y,30,85);
 drawgreetingstext(x+15,y+8);
}

void drawmenu()
{
     if(flag==0)
     {
                drawcrackerstab(0,650);
                drawgreetingstab(0,610);
     }
     if(flag==1)//cracker sub menu
     {
         drawcrackerstab(0,650);
         drawcrackersubmenu(35,624);
         drawgreetingstab(0,500);
     }
     if(flag==2)//greetings sub meu
     {
       drawcrackerstab(0,650);
       drawgreetingstab(0,610);
       drawgreetingssubmenu(35,584);
     }

}
void typekey()
{
	    printf("typeposx is %d,typeposy is %d\n",typeposx,typeposy);
      if(charcount!=0)
           typeposx += 9;
     if(typeposx >= endtypex)//width completed
     {
         typeposx = starttypex;
         typeposy -= 17;
         charcount = 0;
     }
     if(typeposy <= endtypey)//end of card type area in y direction
     {
     return;
     }
    glRasterPos2i(typeposx,typeposy);
 //   glColor3f (0.0, 0.0, 0.0);
    printf("xpos is %d\n and charcount is %d\n",typeposx,charcount);
    switch(c)
           {

             case 13://change line on pressing enter
                  typeposy -= 17;
                  charcount=0;
                  typeposx = starttypex;
                  break;
             case 8://handling backspace so that it does not print a whitespace
                  if(charcount>0)
                   typeposx -=9;
                   break;
             case 'a':
                  glutBitmapCharacter(GLUT_BITMAP_HELVETICA_18,'a');
                  break;
             case 'A':
                  glutBitmapCharacter(GLUT_BITMAP_HELVETICA_18,'A');
             break;

             case 'b':
                  glutBitmapCharacter(GLUT_BITMAP_HELVETICA_18,'b');
                  break;
             case 'B':
                    glutBitmapCharacter(GLUT_BITMAP_HELVETICA_18,'B');
             break;

             case 'c':
                  glutBitmapCharacter(GLUT_BITMAP_HELVETICA_18,'c');
                  break;
             case 'C':
                    glutBitmapCharacter(GLUT_BITMAP_HELVETICA_18,'C');
             break;

             case 'd':
                  glutBitmapCharacter(GLUT_BITMAP_HELVETICA_18,'d');
                  break;
             case 'D':
                    glutBitmapCharacter(GLUT_BITMAP_HELVETICA_18,'D');
             break;

             case 'e':
                  glutBitmapCharacter(GLUT_BITMAP_HELVETICA_18,'e');
                  break;
             case 'E':
                    glutBitmapCharacter(GLUT_BITMAP_HELVETICA_18,'E');
             break;

             case 'f':
                  glutBitmapCharacter(GLUT_BITMAP_HELVETICA_18,'f');
                  break;
             case 'F':
                    glutBitmapCharacter(GLUT_BITMAP_HELVETICA_18,'F');
             break;

             case 'g':
                  glutBitmapCharacter(GLUT_BITMAP_HELVETICA_18,'g');
                  break;
             case 'G':
                    glutBitmapCharacter(GLUT_BITMAP_HELVETICA_18,'G');
             break;

             case 'h':
                  glutBitmapCharacter(GLUT_BITMAP_HELVETICA_18,'h');
                  break;
             case 'H':
                    glutBitmapCharacter(GLUT_BITMAP_HELVETICA_18,'H');
             break;

             case 'i':
                  glutBitmapCharacter(GLUT_BITMAP_HELVETICA_18,'i');
                  break;
             case 'I':
                    glutBitmapCharacter(GLUT_BITMAP_HELVETICA_18,'I');
             break;

             case 'j':
                  glutBitmapCharacter(GLUT_BITMAP_HELVETICA_18,'j');
                  break;
             case 'J':
                    glutBitmapCharacter(GLUT_BITMAP_HELVETICA_18,'J');
             break;

             case 'k':
                  glutBitmapCharacter(GLUT_BITMAP_HELVETICA_18,'k');
                  break;
             case 'K':
                    glutBitmapCharacter(GLUT_BITMAP_HELVETICA_18,'K');
             break;

             case 'l':
                  glutBitmapCharacter(GLUT_BITMAP_HELVETICA_18,'l');
                  break;
             case 'L':
                    glutBitmapCharacter(GLUT_BITMAP_HELVETICA_18,'L');
             break;

             case 'm':
                  glutBitmapCharacter(GLUT_BITMAP_HELVETICA_18,'m');
                  break;
             case 'M':
                    glutBitmapCharacter(GLUT_BITMAP_HELVETICA_18,'M');
             break;

             case 'n':
                  glutBitmapCharacter(GLUT_BITMAP_HELVETICA_18,'n');
                  break;
             case 'N':
                    glutBitmapCharacter(GLUT_BITMAP_HELVETICA_18,'N');
             break;

             case 'o':
                  glutBitmapCharacter(GLUT_BITMAP_HELVETICA_18,'o');
                  break;
             case 'O':
                    glutBitmapCharacter(GLUT_BITMAP_HELVETICA_18,'O');
             break;

             case 'p':
                  glutBitmapCharacter(GLUT_BITMAP_HELVETICA_18,'p');
                  break;
             case 'P':
                    glutBitmapCharacter(GLUT_BITMAP_HELVETICA_18,'P');
             break;

             case 'q':
                  glutBitmapCharacter(GLUT_BITMAP_HELVETICA_18,'q');
                  break;
             case 'Q':
                    glutBitmapCharacter(GLUT_BITMAP_HELVETICA_18,'Q');
             break;

             case 'r':
                  glutBitmapCharacter(GLUT_BITMAP_HELVETICA_18,'r');
                  break;
             case 'R':
                    glutBitmapCharacter(GLUT_BITMAP_HELVETICA_18,'R');
             break;

             case 's':
                  glutBitmapCharacter(GLUT_BITMAP_HELVETICA_18,'s');
                  break;
             case 'S':
                    glutBitmapCharacter(GLUT_BITMAP_HELVETICA_18,'S');
             break;

             case 't':
                  glutBitmapCharacter(GLUT_BITMAP_HELVETICA_18,'t');
                  break;
             case 'T':
                    glutBitmapCharacter(GLUT_BITMAP_HELVETICA_18,'T');
             break;

             case 'u':
                  glutBitmapCharacter(GLUT_BITMAP_HELVETICA_18,'u');
                  break;
             case 'U':
                    glutBitmapCharacter(GLUT_BITMAP_HELVETICA_18,'U');
             break;

             case 'v':
                  glutBitmapCharacter(GLUT_BITMAP_HELVETICA_18,'v');
                  break;
             case 'V':
                    glutBitmapCharacter(GLUT_BITMAP_HELVETICA_18,'V');
             break;

             case 'w':
                  glutBitmapCharacter(GLUT_BITMAP_HELVETICA_18,'w');
                  break;
             case 'W':
                    glutBitmapCharacter(GLUT_BITMAP_HELVETICA_18,'W');
             break;

             case 'x':
                  glutBitmapCharacter(GLUT_BITMAP_HELVETICA_18,'x');
                  break;
             case 'X':
                    glutBitmapCharacter(GLUT_BITMAP_HELVETICA_18,'X');
             break;

             case 'y':
                  glutBitmapCharacter(GLUT_BITMAP_HELVETICA_18,'y');
                  break;
             case 'Y':
                    glutBitmapCharacter(GLUT_BITMAP_HELVETICA_18,'Y');
             break;

             case 'z':
                  glutBitmapCharacter(GLUT_BITMAP_HELVETICA_18,'z');
                  break;
             case 'Z':
                    glutBitmapCharacter(GLUT_BITMAP_HELVETICA_18,'Z');
             break;

             }


}
void drawcard1()
{
	glColor3f(0,0,1);
	//glRectf(150,150,650,650);
	drawtab(150,150,500,500);

	glColor3ub(32,170,178);

	glRectf(165,175,630,625);
	glColor3f(0,0,0);


	glRasterPos2i(250,550);//Happy
	glutBitmapCharacter(GLUT_BITMAP_TIMES_ROMAN_24,'H');
	glutBitmapCharacter(GLUT_BITMAP_TIMES_ROMAN_24,'a');
	glutBitmapCharacter(GLUT_BITMAP_TIMES_ROMAN_24,'p');
	glutBitmapCharacter(GLUT_BITMAP_TIMES_ROMAN_24,'p');
	glutBitmapCharacter(GLUT_BITMAP_TIMES_ROMAN_24,'y');

	glRasterPos2i(280,520);//Diwali
	glutBitmapCharacter(GLUT_BITMAP_TIMES_ROMAN_24,'D');
	glutBitmapCharacter(GLUT_BITMAP_TIMES_ROMAN_24,'i');
	glutBitmapCharacter(GLUT_BITMAP_TIMES_ROMAN_24,'w');
	glutBitmapCharacter(GLUT_BITMAP_TIMES_ROMAN_24,'a');
	glutBitmapCharacter(GLUT_BITMAP_TIMES_ROMAN_24,'l');
	glutBitmapCharacter(GLUT_BITMAP_TIMES_ROMAN_24,'i');

	glRasterPos2i(415,540);//Diwali

		glutBitmapCharacter(GLUT_BITMAP_TIMES_ROMAN_24,'M');
		glutBitmapCharacter(GLUT_BITMAP_TIMES_ROMAN_24,'y');

		glutBitmapCharacter(GLUT_BITMAP_TIMES_ROMAN_24,' ');

		glutBitmapCharacter(GLUT_BITMAP_TIMES_ROMAN_24,'W');
		glutBitmapCharacter(GLUT_BITMAP_TIMES_ROMAN_24,'i');
		glutBitmapCharacter(GLUT_BITMAP_TIMES_ROMAN_24,'s');
		glutBitmapCharacter(GLUT_BITMAP_TIMES_ROMAN_24,'h');
		glutBitmapCharacter(GLUT_BITMAP_TIMES_ROMAN_24,'e');
		glutBitmapCharacter(GLUT_BITMAP_TIMES_ROMAN_24,'s');
		glutBitmapCharacter(GLUT_BITMAP_TIMES_ROMAN_24,',');

		glRasterPos2i(418,500);//Diwali
		glutBitmapCharacter(GLUT_BITMAP_TIMES_ROMAN_24,'-');
		glutBitmapCharacter(GLUT_BITMAP_TIMES_ROMAN_24,'-');


		glLineWidth(3.0);
			glEnable(GL_LINE_STIPPLE);
			glLineStipple(3, 0xF1F1);
			glBegin(GL_LINES);

			//center partition
			glVertex2i(400,175);
			glVertex2i(400,625);

				glEnd();
		glLineStipple(2,0xAAAA);
		glLineWidth(1.0);
		glBegin(GL_LINES);

			//center partition
			glVertex2i(440,500);
			glVertex2i(600,500);

			glVertex2i(440,484);
			glVertex2i(600,484);

			glVertex2i(440,465);
			glVertex2i(600,465);

			glVertex2i(440,449);
			glVertex2i(600,449);

			glVertex2i(440,433);
			glVertex2i(600,433);

			glVertex2i(440,415);
			glVertex2i(600,415);

			glVertex2i(440,399);
			glVertex2i(600,399);

			glVertex2i(440,383);
			glVertex2i(600,383);


glEnd();

	glLineWidth(5.0);
			glBegin(GL_LINES);
				//left top
				glVertex2i(165,520);
				glVertex2i(230,624);
				glVertex2i(165,500);
				glVertex2i(243,624);

				//right bottom
				glVertex2i(630,280);
				glVertex2i(565,175);
				glVertex2i(630,300);
				glVertex2i(552,175);

				//right top
				glVertex2i(630,520);
				glVertex2i(565,624);
				glVertex2i(630,500);
				glVertex2i(552,624);


				glVertex2i(165,280);
				glVertex2i(230,175);
				glVertex2i(165,300);
				glVertex2i(243,175);


			glEnd();
		glDisable(GL_LINE_STIPPLE);


	printf("card1 is drawn now\n");
}
void drawcard2()
{
	glColor3f(0,0,1);
		//glRectf(150,150,650,650);
		drawtab(150,150,500,500);

		glColor3ub(32,170,178);

		glRectf(155,160,645,640);
		glColor3f(0,0,0);

		glLineWidth(3.0);
		glBegin(GL_LINES);

					//vertical plus
					glVertex2i(180,580);
					glVertex2i(180,620);

					//horizontal plus
					glVertex2i(165,600);
					glVertex2i(195,600);

					//left rise
					glVertex2i(165,600);
					glVertex2i(165,620);

					//right fall
					glVertex2i(195,600);
					glVertex2i(195,580);

					//right turn
					glVertex2i(180,620);
					glVertex2i(195,620);

					//left turn
					glVertex2i(180,581);
					glVertex2i(165,581);

					//left bottom telda
					glVertex2i(165,581);
					glVertex2i(162,576);

					//left top telda
					glVertex2i(165,619);
					glVertex2i(162,623);

					//right bottom telda
					glVertex2i(195,581);
					glVertex2i(198,576);

					//right top telda
					glVertex2i(195,619);
					glVertex2i(198,623);


		glEnd();

		glPushMatrix();
		glTranslatef(440,-400,0);

		glBegin(GL_LINES);

							//vertical plus
							glVertex2i(180,580);
							glVertex2i(180,620);

							//horizontal plus
							glVertex2i(165,600);
							glVertex2i(195,600);

							//left rise
							glVertex2i(165,600);
							glVertex2i(165,620);

							//right fall
							glVertex2i(195,600);
							glVertex2i(195,580);

							//right turn
							glVertex2i(180,620);
							glVertex2i(195,620);

							//left turn
							glVertex2i(180,581);
							glVertex2i(165,581);

							//left bottom telda
							glVertex2i(165,581);
							glVertex2i(162,576);

							//left top telda
							glVertex2i(165,619);
							glVertex2i(162,623);

							//right bottom telda
							glVertex2i(195,581);
							glVertex2i(198,576);

							//right top telda
							glVertex2i(195,619);
							glVertex2i(198,623);


				glEnd();

		glPopMatrix();

		glRasterPos2i(250,550);//Happy
		glutBitmapCharacter(GLUT_BITMAP_TIMES_ROMAN_24,'H');
		glutBitmapCharacter(GLUT_BITMAP_TIMES_ROMAN_24,'a');
		glutBitmapCharacter(GLUT_BITMAP_TIMES_ROMAN_24,'p');
		glutBitmapCharacter(GLUT_BITMAP_TIMES_ROMAN_24,'p');
		glutBitmapCharacter(GLUT_BITMAP_TIMES_ROMAN_24,'y');

		glRasterPos2i(280,520);//Diwali
		glutBitmapCharacter(GLUT_BITMAP_TIMES_ROMAN_24,'D');
		glutBitmapCharacter(GLUT_BITMAP_TIMES_ROMAN_24,'i');
		glutBitmapCharacter(GLUT_BITMAP_TIMES_ROMAN_24,'w');
		glutBitmapCharacter(GLUT_BITMAP_TIMES_ROMAN_24,'a');
		glutBitmapCharacter(GLUT_BITMAP_TIMES_ROMAN_24,'l');
		glutBitmapCharacter(GLUT_BITMAP_TIMES_ROMAN_24,'i');

		glRasterPos2i(415,540);//Diwali

			glutBitmapCharacter(GLUT_BITMAP_TIMES_ROMAN_24,'M');
			glutBitmapCharacter(GLUT_BITMAP_TIMES_ROMAN_24,'y');

			glutBitmapCharacter(GLUT_BITMAP_TIMES_ROMAN_24,' ');

			glutBitmapCharacter(GLUT_BITMAP_TIMES_ROMAN_24,'W');
			glutBitmapCharacter(GLUT_BITMAP_TIMES_ROMAN_24,'i');
			glutBitmapCharacter(GLUT_BITMAP_TIMES_ROMAN_24,'s');
			glutBitmapCharacter(GLUT_BITMAP_TIMES_ROMAN_24,'h');
			glutBitmapCharacter(GLUT_BITMAP_TIMES_ROMAN_24,'e');
			glutBitmapCharacter(GLUT_BITMAP_TIMES_ROMAN_24,'s');
			glutBitmapCharacter(GLUT_BITMAP_TIMES_ROMAN_24,',');

			glRasterPos2i(418,500);//Diwali
			glutBitmapCharacter(GLUT_BITMAP_TIMES_ROMAN_24,'-');
			glutBitmapCharacter(GLUT_BITMAP_TIMES_ROMAN_24,'-');


			glLineWidth(3.0);
			glEnable(GL_LINE_STIPPLE);
			glLineStipple(3, 0xF1F1);
			glBegin(GL_LINES);
				//center partition
				glVertex2i(400,175);
				glVertex2i(400,625);
			glEnd();
			glLineStipple(2,0xAAAA);
			glLineWidth(1.0);
			glBegin(GL_LINES);

				//center partition
				glVertex2i(440,500);
				glVertex2i(600,500);

				glVertex2i(440,484);
				glVertex2i(600,484);

				glVertex2i(440,465);
				glVertex2i(600,465);

				glVertex2i(440,449);
				glVertex2i(600,449);

				glVertex2i(440,433);
				glVertex2i(600,433);

				glVertex2i(440,415);
				glVertex2i(600,415);

				glVertex2i(440,399);
				glVertex2i(600,399);

				glVertex2i(440,383);
				glVertex2i(600,383);


	glEnd();


			glDisable(GL_LINE_STIPPLE);

     printf("card2 is drawn now\n");
}
void greet()
{
    glColor3f(0.0,0,0);
    if(card==1 && charcount==-1)
    {
               drawcard1();

    }
    if(card==2)
    {
               drawcard2();

    }
    if(newkey==1)
    {
       typekey();
    }
    newkey =0;

}

void drawbomb()
{
    if(bomb==1)
        {
               printf("bomb1 is to called here\n");
       }
    if(bomb==2)
        {

               printf("bomb2 is to called here\n");
               //display_bomb();
               //glDisable(GL_DEPTH_TEST);
        }
    if(bomb==3)
        printf("bomb3 is to called here\n");
}
void display( )      /* to display characters */
{
  //glClear(GL_COLOR_BUFFER_BIT );
    glLoadIdentity();
    glMatrixMode(GL_MODELVIEW);
    glPixelStorei (GL_UNPACK_ALIGNMENT, 1);
   /*drawmenu();
   if(card!=0)
   {
     greet();
   }
   if(bomb!=0)
   {
    printf("drawbomb is called\n");
    drawbomb();
   }*/



   glFlush();                       /* send all commands */
}
void MyKey (GLubyte key, GLint x, GLint y)   //To take input fom keyboard
{

  charcount++;
  newkey =1;
  c=key;
   //printf("char is  %d \n newkey is %d\n",c,newkey);
if(flag==2)
 glutPostRedisplay();

}
void mouse(GLint button, GLint state, GLint x, GLint y)

{

     if(button==GLUT_LEFT_BUTTON && state==GLUT_DOWN)
       {

        printf("x is %d \ny is %d ",x,y);

          if(flag==0)
          {

              if (x<112 && x>25 && y>75 && y<95)
              {
                        flag = 1;
              }
              if (x<120 && x>25 && y>118 && y<136)
              {
                        flag=2;
              }
          }

          if(flag==1)
          {

                    if (x<120 && x>25 && y>228 && y<250 )
                    {
                    flag = 2;
                    }
                    if(x>64 && x<131 && y>100 && y<130)
                    {
                    bomb = 1;
                    card=0;
                    printf("bomb1");
                    }
                    if(x>64 && x<121 && y>147 && y<164)
                    {
                            printf("bomb is now 2\n");
                    bomb = 2;
                    card=0;
                    printf("bomb2");
                    }
                    if(x>64 && x<125 && y>180 && y<197)
                    {
                    bomb = 3;
                    card=0;
                    printf("bomb3");
          }

          }
          if(flag==2)
          {
              if(x>=64 && x<124 && y>=152 && y<169)
              {
                printf("changing the positions in card1\n");
                typeposx = starttypex;
                typeposy = starttypey;
                charcount = -1;
                bomb=0;
                card = 1;

              }

              else
              card=0;

              if(x>=64 && x<124 && y>=188 && y<205)
              {
                printf("changing the positions in card2\n");
                typeposx = starttypex;
                typeposy = starttypey;
                charcount = -1;
                bomb=0;
                card = 2;

              }
              if (x<112 && x>25 && y>75 && y<95)
              {
                        flag = 1;
              }


          }
          glClear(GL_COLOR_BUFFER_BIT | GL_DEPTH_BUFFER_BIT);
          glutPostRedisplay();
       }


}
void reshape (int w, int h)
{
    glViewport(0, 0, (GLsizei) w, (GLsizei) h);
    glMatrixMode(GL_PROJECTION);
    glLoadIdentity();
    glOrtho(0,750.0,0,750.0,-750.0,750.0);
    glMatrixMode(GL_MODELVIEW);
    glLoadIdentity();
}
int main(int argc, char** argv)
{
   glutInit(&argc,argv);                                   /*initialize the toolkit   */
   glutInitWindowSize( 1366,768 );                         /* Set window size */
   glutInitDisplayMode( GLUT_RGB | GLUT_SINGLE | GLUT_DEPTH);           /* Set the display mode */
   glutInitWindowPosition( 0, 0 );
   glutCreateWindow("Diwali Menu ");                          /* create window with title */
   glutDisplayFunc(display);                               /*tell OpenGL main loop what     */
   myinit();
   PlaySound(TEXT("D:\\Documents\\Java codes\\Hello\\test.mp3"), NULL, SND_FILENAME | SND_ASYNC);
//   init();
   //glutKeyboardFunc(MyKey);                                  /* set attributes                 */
   glutReshapeFunc(reshape);
   //glutMouseFunc(mouse);
   glutMainLoop();                                         /* pass control to the main loop  */
   return 0;
}

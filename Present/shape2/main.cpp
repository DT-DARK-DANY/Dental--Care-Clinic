/*
 /*
 * GLUT Shapes Demo
 *
 * Written by Nigel Stewart November 2003
 *
 * This program is test harness for the sphere, cone
 * and torus shapes in GLUT.
 *
 * Spinning wireframe and smooth shaded shapes are
 * displayed until the ESC or q key is pressed.  The
 * number of geometry stacks and slices can be adjusted
 * using the + and - keys.
 */

#ifdef __APPLE__

#else
#include <GL/glut.h>
#endif
#include <stdio.h>
#include <stdlib.h>

/* GLUT callback Handlers */



 void display(void){
glClearColor(0,0,0,0);
 glClear(GL_COLOR_BUFFER_BIT);
 glLineWidth(3);
  glBegin(GL_LINE_LOOP);
  glColor3f(1,0,0);
  glVertex2f(2.0,4.0);
  glVertex2f(5.5,4.0);
  glVertex2f(2.0,6.0);
  glVertex2f(5.5,6.0);
  glVertex2f(2.0,4.0);
  glVertex2f(5.5,6.0);
  glVertex2f(5.5,4.0);
  glVertex2f(2.0,6.0);


glEnd();

glFlush();
}
int main(int argc, char** argv){
    glutInit(&argc, argv);
 glutInitDisplayMode (GLUT_SINGLE);
glutInitWindowPosition(400,100);
glutInitWindowSize(600,600);
glutCreateWindow("Shape 2");

   //   left   Right bottom top  znear zfar
 glOrtho(-3.0, 10.0, 0.0, 10.0, -1.0, 1.0);
    glutDisplayFunc(display);
    glutMainLoop();

    return EXIT_SUCCESS;
}

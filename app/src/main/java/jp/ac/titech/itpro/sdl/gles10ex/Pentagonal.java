package jp.ac.titech.itpro.sdl.gles10ex;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;

import javax.microedition.khronos.opengles.GL10;

public class Pentagonal implements SimpleRenderer.Obj {

    private FloatBuffer vbuf;
    private float x, y, z;

    public Pentagonal(float s, float x, float y, float z) {
        float[] vertices = {
                //front
                0, 0, 0,
                0.5F*s, 1.54F*s, 0,
                1.31F*s, 0.95F*s, 0,
                -0.31F*s, 0.95F*s, 0,
                0, 0, 0,
                1.31F*s, 0.95F*s, 0,
                s, 0, 0,
                ///1
                0, 0, 0,
                -0.31F*s, 0.95F*s, 0,
                0, 0, s,
                -0.31F*s, 0.95F*s, s,
                ///2
                -0.31F*s, 0.95F*s, 0,
                0.5F*s, 1.54F*s, 0,
                -0.31F*s, 0.95F*s, s,
                0.5F*s, 1.54F*s, s,
                ///3
                0.5F*s, 1.54F*s, 0,
                1.31F*s, 0.95F*s, 0,
                0.5F*s, 1.54F*s, s,
                1.31F*s, 0.95F*s, s,
                ///4
                1.31F*s, 0.95F*s, 0,
                s, 0, 0,
                1.31F*s, 0.95F*s, s,
                s, 0, s,
                ///5
                s, 0, 0,
                0, 0, 0,
                s, 0, s,
                0, 0, s,
                ///back
                0, 0, s,
                0.5F*s, 1.54F*s, s,
                1.31F*s, 0.95F*s, s,
                -0.31F*s, 0.95F*s, s,
                0, 0, s,
                1.31F*s, 0.95F*s, s,
                s, 0, s,
        };
        vbuf = ByteBuffer.allocateDirect(vertices.length * 4)
                .order(ByteOrder.nativeOrder()).asFloatBuffer();
        vbuf.put(vertices);
        vbuf.position(0);
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public void draw(GL10 gl) {
        gl.glEnableClientState(GL10.GL_VERTEX_ARRAY);
        gl.glVertexPointer(3, GL10.GL_FLOAT, 0, vbuf);

        // front
        gl.glNormal3f(0, 0, -1);
        gl.glDrawArrays(GL10.GL_TRIANGLE_STRIP, 0, 7);
        // 1
        gl.glNormal3f(-0.8F, -0.2F, 0);
        gl.glDrawArrays(GL10.GL_TRIANGLE_STRIP, 7, 4);
        // 2
        gl.glNormal3f(-0.2F, 0.8F, 0);
        gl.glDrawArrays(GL10.GL_TRIANGLE_STRIP, 11, 4);
        // 3
        gl.glNormal3f(0.2F, 0.8F, 0);
        gl.glDrawArrays(GL10.GL_TRIANGLE_STRIP, 15, 4);
        // 4
        gl.glNormal3f(0.8F, -0.2F, 0);
        gl.glDrawArrays(GL10.GL_TRIANGLE_STRIP, 19, 4);
        // 5
        gl.glNormal3f(0, -1, 0);
        gl.glDrawArrays(GL10.GL_TRIANGLE_STRIP, 23, 4);
        // top
        gl.glNormal3f(0, 0, 1);
        gl.glDrawArrays(GL10.GL_TRIANGLE_STRIP, 27, 7);
    }
    @Override
    public float getX() {
        return x;
    }

    @Override
    public float getY() {
        return y;
    }

    @Override
    public float getZ() {
        return z;
    }
}

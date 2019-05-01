package p01_SingleResponsibility;

import p01_SingleResponsibility.intefaces.DrawingManager;
import p01_SingleResponsibility.intefaces.DrawingRepository;
import p01_SingleResponsibility.intefaces.Rengerer;
import p01_SingleResponsibility.intefaces.Shape;


public class DrawingManagerImpl implements DrawingManager {

    private final DrawingRepository drawingRepository;
    private final Rengerer renderer;

    public DrawingManagerImpl(DrawingRepository drawingRepository, Rengerer renderer) {
        this.drawingRepository = drawingRepository;
        this.renderer = renderer;
    }


    @Override
    public void draw(Shape shape) {
        shape.draw(this.renderer, this.drawingRepository);
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fog.domain;

/**
 *
 * @author Pravien
 */
public class Material
{
    private int id;
    private String name, type;
    private double size;

    public Material(int id, String name, String type, double size)
    {
        this.id = id;
        this.name = name;
        this.type = type;
        this.size = size;
    }

    public int getId()
    {
        return id;
    }

    public void setId(int id)
    {
        this.id = id;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public String getType()
    {
        return type;
    }

    public void setType(String type)
    {
        this.type = type;
    }

    public double getSize()
    {
        return size;
    }

    public void setSize(double size)
    {
        this.size = size;
    }   
}



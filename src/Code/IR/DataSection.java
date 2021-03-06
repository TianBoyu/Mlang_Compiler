package Code.IR;

import Code.IR.IRUnit.Oprands.Address;

import java.util.LinkedList;
import java.util.List;

public class DataSection
{
    public class DataPiece
    {
        private String strValue;
        private String otherValue;
        private String op;
        private String name;
        private int length;

        public DataPiece(String name, String str_value)
        {
            if(str_value != null)
            {
                this.strValue = str_value;
                this.length = str_value.length();
            }
            this.name = name;
        }

        public DataPiece(String name, String value, String op)
        {
            this.name = name;
            this.otherValue = value;
            this.op = op;
        }

        public String getOtherValue(){
            return otherValue;
        }
        public String getStrValue()
        {
            return strValue;
        }
        public String getName()
        {
            return name;
        }
        public int getLength()
        {
            return length;
        }
        public String toString()
        {
            return name + ": " + strValue;
        }
    }

    public DataSection()
    {
        dataPieces = new LinkedList<>();
    }

    public String addData(String name, String value)
    {
        dataPieces.add(new DataPiece(name, value));
        return name;
    }
    public String addData(String name, String value, String op)
    {
        dataPieces.add(new DataPiece(name, value, op));
        return name;
    }

    public String addData(String value)
    {
        String name = "String_" + String.valueOf(piece_number++);
        dataPieces.add(new DataPiece(name, value));
        return name;
    }

    public List<DataPiece> getDataPieces()
    {
        return dataPieces;
    }

    private List<DataPiece> dataPieces;
    private static int piece_number = 0;
}

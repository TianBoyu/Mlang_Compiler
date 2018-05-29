package Code.IR;

import java.util.LinkedList;
import java.util.List;

public class DataSection
{
    public class DataPiece
    {
        private String strValue;
        private int intValue;
        private String name;
        private int length;

        public DataPiece(String name, String str_value)
        {
            this.strValue = str_value;
            this.name = name;
            this.length = str_value.length();
        }

        public DataPiece(String name, int intValue)
        {
            this.intValue = intValue;
            this.name = name;
        }

        public int getIntValue()
        {
            return intValue;
        }

        public String getValue()
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
    public String addData(String name, int value)
    {
        dataPieces.add(new DataPiece(name,value));
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

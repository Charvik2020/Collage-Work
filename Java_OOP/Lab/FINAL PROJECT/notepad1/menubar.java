package notepad1;

import java.io.*;
import java.util.*;

public abstract class menubar 
{
    abstract void open_file(String Filename_open,String Extention_open);
    abstract void save_file(String Filename_save,String Extention_save);
    abstract void new_file(String Filename,String Extention);
}

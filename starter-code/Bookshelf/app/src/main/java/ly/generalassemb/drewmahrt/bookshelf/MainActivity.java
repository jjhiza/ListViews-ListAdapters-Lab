package ly.generalassemb.drewmahrt.bookshelf;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    BaseAdapter mBookAdapter;

    //TODO: Define your ListView

    ListView listView;


    //TODO: Define your Book List

    List <Book> mBookList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Use helper method to add books to the list
        mBookList = generateBooks();

        //TODO: Instantiate BaseAdapter
        //Below is a partially complete example for one Adapter
        mBookAdapter = new BaseAdapter() {
            @Override
            public int getCount() {

                return mBookList.size();
            }

            @Override
            public Object getItem(int position) {

                return mBookList.get(position);
            }

            @Override
            public long getItemId(int position) {

                return position;
            }

            @Override
            public View getView(int position, View convertView, ViewGroup parent) {
                //TODO: Update the view

                if (counterView == null) {
                    LayoutInflater inflater = LayoutInflater.from(MainActivity.this);
                    convertView = inflater.inflate(android.R.layout.simple_list_item_2, null);

                }

                TextView textView = (TextView) convertView.findViewById(android.R.id.text1);
                textView.setText(mBookList.get(position).getTitle());

                TextView textView2 = (TextView) counterView.findViewById(android.R.id.text2);
                textView2.setText(mBookList.get(position).getAuthor());

                return convertView;
            }
        };

        //TODO: Set the ListView's adapter

        listView.setAdapter(mBookList);
        mBookAdapter.notifyDataSetChanged();

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                TextView textView = (TextView) view.findViewById(android.R.id.text1);
                TextView textView2 = (TextView) view.findViewById(android.R.id.text2);
                textView.setTextColor(Color.RED);
                textView2.setTextColor(Color.RED);
                mBookAdapter.notifyDataSetChanged();
            }
                                        }

        //mBookAdapter = new ArrayAdapter<String>(MainActivity.this, android.R.layout.simple_list_item_1, mStringList);


    }

    //Method to generate a list of Books
    private List<Book> generateBooks(){
        List<Book> books = new ArrayList<>();

        books.add(new Book("Apples Book","Brad"));
        books.add(new Book("Cats Book","Ryan"));
        books.add(new Book("Eagles Book","Kate"));
        books.add(new Book("Strawberries Cathy","Brad"));
        books.add(new Book("Dogs Book","Tom"));
        books.add(new Book("Ants Book","Zane"));

        return books;
    }
}

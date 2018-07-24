package viewmodel;

import android.databinding.BaseObservable;
import android.databinding.BindingAdapter;
import android.widget.ImageView;

import com.android.databinding.library.baseAdapters.BR;
import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.infosysprogram.test.R;

import api.RetrofitCallFunction;
import model.Dataclass;
import model.Row;



public class ItemDayViewModel extends BaseObservable {

    private Row rowClass;
    private Dataclass data;

    private String title;
    private String content;
    private String imageURL;


    public ItemDayViewModel(Row rowItem) {
        this.data = data;
        this.rowClass=rowItem;
    }

    public Row getRowClass() {
        return rowClass;
    }

    public void setRowClass(Row rowClass) {
        this.rowClass = rowClass;
    }

    public Dataclass getData() {
        return data;
    }

    public void setData(Dataclass data) {
        this.data = data;
    }

    public String getTitle() {

        title = rowClass.getTitle();
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {

        content  =  rowClass.getDescription();
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getImageURL() {

        imageURL = rowClass.getImageHref();
        return imageURL;
    }

    public void setImageURL(String imageURL) {
        this.imageURL = imageURL;
       // notifyPropertyChanged(B);
    }

    @BindingAdapter("bind:imageHref" )
    public static void loadImage(ImageView view, String imageUri){


        RequestOptions requestOptions = new RequestOptions();
        requestOptions.placeholder(R.drawable.ic_launcher_background);
        requestOptions.error(R.drawable.ic_launcher_background);
        requestOptions.apply(new RequestOptions().override(600, 200));

        Glide.with(view.getContext()).applyDefaultRequestOptions(requestOptions) .load(imageUri).into(view);

  }
}
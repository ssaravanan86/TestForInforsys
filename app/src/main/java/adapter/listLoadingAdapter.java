package adapter;

import android.databinding.DataBindingUtil;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.example.infosysprogram.test.R;
import com.example.infosysprogram.test.databinding.RowValueItemBinding;

import java.util.List;

import model.Dataclass;
import model.Row;
import viewmodel.ItemDayViewModel;

public class listLoadingAdapter extends RecyclerView.Adapter<listLoadingAdapter.dataHolder> {

    private List<Row> rowClass;


    @Override
    public dataHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        RowValueItemBinding binding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()),
                R.layout.row_value_item, parent, false);
        return new dataHolder(binding);
    }

    @Override
    public void onBindViewHolder(dataHolder holder, int position) {
        RowValueItemBinding binding = holder.binding;
        binding.setItem(new ItemDayViewModel(rowClass.get(position)));
    }

    @Override
    public int getItemCount() {
        return rowClass.size();
    }

    public static class dataHolder extends RecyclerView.ViewHolder {
        private  RowValueItemBinding binding;

        public dataHolder(RowValueItemBinding binding) {
            super(binding.listLayout);
            this.binding = binding;
        }
    }

    public listLoadingAdapter(List<Row> rowClass) {
        this.rowClass = rowClass;
    }
}

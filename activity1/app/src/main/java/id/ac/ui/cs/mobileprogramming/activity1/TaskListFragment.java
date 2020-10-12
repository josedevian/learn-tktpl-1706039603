package id.ac.ui.cs.mobileprogramming.activity1;

import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.lifecycle.ViewModelProvider;
import id.ac.ui.cs.mobileprogramming.activity1.databinding.FragmentTaskListBinding;
import id.ac.ui.cs.mobileprogramming.activity1.databinding.ListItemsBinding;

import java.util.ArrayList;
import java.util.List;

public class TaskListFragment extends Fragment {
    private FragmentTaskListBinding binding;
    private DetailsFragment detailsFragment = new DetailsFragment();

    public TaskListFragment() {
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_task_list, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        SharedViewModel viewModel = new ViewModelProvider(requireActivity()).get(SharedViewModel.class);
        List<Item> list = new ArrayList<>();
        list.add(new Item("TKTPL", "Lab", "Implementasi sederhana MVVM"));
        list.add(new Item("DAA", "Forum", "Worksheet Recurrence"));
        list.add(new Item("Pengcit", "Lab", "Smoothing, Sharpen pada RGB dan HSV Channel"));

        RecyclerViewAdapter adapter = new RecyclerViewAdapter(list);
        binding.recyclerView.setAdapter(adapter);
        adapter.setListener((v, position) -> {
            viewModel.setSelected(adapter.getItemAt(position));
            getParentFragmentManager().beginTransaction()
                    .replace(R.id.container, detailsFragment)
                    .addToBackStack(null)
                    .commit();
        });
    }
}
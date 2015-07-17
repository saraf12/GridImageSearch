package codepath.com.gridimagesearch.adapters;

import android.content.Context;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

import codepath.com.gridimagesearch.R;
import codepath.com.gridimagesearch.models.ImageResult;

public class ImageResultsAdapter extends ArrayAdapter<ImageResult> {

    public ImageResultsAdapter(Context context, List<ImageResult> images) {
        super(context, R.layout.item_image_result, images);
    }

    @Override
    public View getView(int position,View convertView, ViewGroup parent) {
        ImageResult imageInfo = getItem(position);
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.item_image_result, parent, false);
        }
        ImageView IvImage = (ImageView) convertView.findViewById(R.id.IvImage);
        TextView tvTitle = (TextView) convertView.findViewById(R.id.tvTitle);
        // Clear out image from last time
        IvImage.setImageResource(0);
        // Populate title and remote download image url
        tvTitle.setText(Html.fromHtml(imageInfo.title));
        // Remotely download the image data in the background (with Picasso)
        Picasso.with(getContext()).load(imageInfo.thumbUrl).into(IvImage);
        // return the completed view to be displayed
        return convertView;
    }

}

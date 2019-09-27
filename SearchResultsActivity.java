public class SearchResultsActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        handleIntent(getIntent());
    }

    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);

        handleIntent(intent);
    }

    private void handleIntent(Intent intent) {

        if (Intent.ACTION_SEARCH.equals(intent.getAction())) {
            String query = intent.getStringExtra(SearchManager.QUERY);
            if (query.toLowerCase().contains("háj")){
                Intent mintent = new Intent(SearchResultsActivity.this, Second.class);
                startActivity(mintent);
                finish();
            }
        }
    }

    private void showResults(String query) {
        // Query your data set and show results
        // ...
    }
}

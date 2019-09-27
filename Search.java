
public class MainActivity extends AppCompatActivity {
    private static final String[] SUGGESTIONS = {"Anděl", "Bořislavka", "Budějovická", "Chodov", "Dejvická", "Depo Hostivař", "Flora", "Florenc - B", "Florenc - C", "Hlavní nádraží", "Hloubětín", "Hradčanská", "Háje", "Hůrka", "I. P. Pavlova", "Invalidovna", "Jinonice", "Jiřího z Poděbrad", "Karlovo náměstí", "Kačerov", "Kobylisy", "Kolbenova", "Křižíkova", "Letňany", "Luka", "Lužiny", "Ládví", "Malostranská", "Muzeum - A", "Muzeum - C", "Můstek - A", "Můstek - B", "Nemovnice Motol", "Nové Butovice", "Nádraží Holešovice", "Nádraží Veleslavín", "Náměstí Míru", "Náměstí Republiky", "Národní třída", "Opatov", "Palmovka", "Pankrác", "Petřiny", "Pražského Povstání", "Prosek", "Radlická", "Rajská zahrada", "Roztyly", "Skalka", "Smíchovské nádraží", "Staroměstská", "Stodůlky", "Strašnická", "Střížkov", "Vltavská", "Vysočanská", "Vyšehrad", "Zličín", "Černý Most", "Českomoravská", "Želivského"};
    
// +-, nevim presne jestli budu pouzivat takovyhle searchView
 searchView = (SearchView)rootview.findItem(R.id.action_search).getActionView();
            SearchManager searchManager = (SearchManager) MainActivity.this.getSystemService(Context.SEARCH_SERVICE);
            searchView.setSubmitButtonEnabled(true);
            searchView.setSuggestionsAdapter(mAdapter);
            searchView.setSearchableInfo(searchManager.getSearchableInfo(getComponentName()));
            searchView.setIconifiedByDefault(false); // Do not iconify the widget; expand it by default
            searchView.setOnSuggestionListener(new SearchView.OnSuggestionListener() {
                @Override
                public boolean onSuggestionClick(int position) {
                    // Your code here
                    String suggestion = getSuggestion(position);
                    try{
                        int cislo = Integer.parseInt(suggestion);
                        searchView.setQuery(SUGGESTIONS[cislo], true);
                    }catch (Exception e){
                        searchView.setQuery(suggestion, true);
                    }
                    return true;
                }

                @Override
                public boolean onSuggestionSelect(int position) {
                    // Your code here
                    return true;
                }
            });

            searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
                @Override
                public boolean onQueryTextSubmit(String s) {
                    return false;
                }

                @Override
                public boolean onQueryTextChange(String s) {
                    populateAdapter(s);
                    return false;
                }
            });
            return true;
    
    
    // mehods for search to even work
      @Override
    public boolean onSearchRequested() {
        Bundle appData = new Bundle();
        appData.putString("hello", "world");
        startSearch(null, false, appData, false);
        return true;
    }
    private String getSuggestion(int position) {
        Cursor cursor = (Cursor) searchView.getSuggestionsAdapter().getItem(position);
        String suggest1 = cursor.getString(1);
        return suggest1;
    }
    @Override
    protected void onNewIntent(Intent intent) {
        setIntent(intent);
        handleIntent(intent);
    }
    private void populateAdapter(String query) {
        final MatrixCursor c = new MatrixCursor(new String[]{ BaseColumns._ID, "cityName" });
        for (int i=0; i<SUGGESTIONS.length; i++) {
            if (SUGGESTIONS[i].toLowerCase().startsWith(query.toLowerCase()))
                c.addRow(new Object[] {i, SUGGESTIONS[i]});
        }
        mAdapter.changeCursor(c);
    }
    private void handleIntent(Intent intent) {
        if (Intent.ACTION_SEARCH.equals(intent.getAction())) {
            String query = intent.getStringExtra(SearchManager.QUERY);
            Intent mintent;
            if (query.toLowerCase().contains(club.getName()){
                // Proste odnaviguj do danyho clubu
               Navigation.navigate...
            }
            finish();
        }
    }
}

package ma.uiass.eia.pds.frontend.Table;

public interface TableActionEvent {

    public void onEdit(int row);

    public void onDelete(int row);

    public void onView(int row);
}
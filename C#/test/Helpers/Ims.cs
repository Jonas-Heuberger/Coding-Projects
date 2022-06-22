namespace test.Helpers
{
    public static class Ims{
        public static string GetSqlParameterStringFromList(List<SqlParameter> list){
            var sParams = "";
            foreach(var o in list){
                sParams += (string.IsNullOrEmpty(sParams) ? "" : ",") + o.ParameterName + " = " + o.ParameterName;
            }
            return sParams;
        }
    }   
}
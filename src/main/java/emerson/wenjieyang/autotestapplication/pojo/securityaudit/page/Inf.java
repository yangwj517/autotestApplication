package emerson.wenjieyang.autotestapplication.pojo.securityaudit.page;

public class Inf{
        // 接口ID
        private String interfaceId ;

        // 操作码
        private String actionCode ;

        // 块类型
        private String partType ;

        // 描述
        private String desc ;

        // 构造函数
        public Inf(String interfaceId, String actionCode, String partType, String desc) {
            this.interfaceId = interfaceId;
            this.actionCode = actionCode;
            this.partType = partType;
            this.desc = desc;
        }
        public Inf(String interfaceId, String actionCode, String partType) {
            this.interfaceId = interfaceId;
            this.actionCode = actionCode;
            this.partType = partType;
        }
        public Inf() {
        }

        // Getter

        public String getInterfaceId() {
            return interfaceId;
        }

        public String getActionCode() {
            return actionCode;
        }

        public String getPartType() {
            return partType;
        }

        public String getDesc() {
            return desc;
        }

        @Override
        public String toString() {
            return "Inf{" +
                    "接口ID='" + interfaceId + '\'' +
                    ", 操作码='" + actionCode + '\'' +
                    ", 块类型='" + partType + '\'' +
                    ", 描述='" + desc + '\'' +
                    '}';
        }
    }
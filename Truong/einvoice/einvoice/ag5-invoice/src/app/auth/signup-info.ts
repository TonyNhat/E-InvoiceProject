export class SignUpInfo {
    name: string;
    username: string;
    email: string;
    role: string[];
    password: string;
    address: string;
    phone: string;

    constructor(name: string, username: string, email: string, password: string, address: string, phone: string) {
        this.name = name;
        this.username = username;
        this.email = email;
        this.password = password;
        this.role = ['user'];
        this.address = address;
        this.phone = phone;
    }
}

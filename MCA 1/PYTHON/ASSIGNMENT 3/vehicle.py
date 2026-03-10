class RentError(Exception):
    pass

class DaysError(Exception):
    pass


class Vehicle:
    def __init__(self, vid, model, rent_per_day, available=True):
        self.id = vid
        self.model = model
        self.rent_per_day = rent_per_day
        self.available = available

    def vehicle_type(self):
        return "Vehicle"


class Car(Vehicle):
    def vehicle_type(self):
        return "Car"


class Bike(Vehicle):
    def vehicle_type(self):
        return "Bike"


class RentalService:
    def __init__(self):
        self.vehicles = []

    def add_vehicle(self, v):
        self.vehicles.append(v)

    def __iter__(self):
        for v in self.vehicles:
            if v.available:
                yield v

    def display_all(self):
        print("\n--- All Vehicles ---")
        for v in self.vehicles:
            print(f"ID:{v.id} | {v.vehicle_type()} | Model:{v.model} | Rent:{v.rent_per_day} | Available:{v.available}")

    def rent_vehicle(self, vid, days):
        if days <= 0:
            raise DaysError("Invalid days entered.")

        for v in self.vehicles:
            if v.id == vid:
                if not v.available:
                    raise RentError("Vehicle not available.")
                v.available = False
                cost = days * v.rent_per_day
                print(f"Vehicle Rented. Total bill: {cost}")
                return
        print("Vehicle not found.")

    def return_vehicle(self, vid):
        for v in self.vehicles:
            if v.id == vid:
                v.available = True
                print("Vehicle Returned.")
                return
        print("Vehicle not found.")


service = RentalService()

service.add_vehicle(Car(1, "Honda City", 1000))
service.add_vehicle(Car(2, "Swift", 800))
service.add_vehicle(Bike(3, "Activa", 300))
service.add_vehicle(Bike(4, "Bullet", 500))

while True:
    print("\n1.Display All Vehicles\n2.Display Available Vehicles\n3.Rent Vehicle\n4.Return Vehicle\n5.Exit")
    ch = input("Enter choice: ")

    if ch == "1":
        service.display_all()

    elif ch == "2":
        print("\n--- Available Vehicles ---")
        for v in service:
            print(f"ID:{v.id} | {v.vehicle_type()} | {v.model} | Rent:{v.rent_per_day}")

    elif ch == "3":
        try:
            vid = int(input("Enter Vehicle ID: "))
            days = int(input("Enter No. of Days: "))
            service.rent_vehicle(vid, days)
        except RentError as r:
            print(r)
        except DaysError as d:
            print(d)

    elif ch == "4":
        vid = int(input("Enter Vehicle ID to return: "))
        service.return_vehicle(vid)

    elif ch == "5":
        break

    else:
        print("Invalid choice.")
